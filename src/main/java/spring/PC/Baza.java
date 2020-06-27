package spring.PC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.PC.Components.*;
import spring.PC.Order.Customer;
import spring.PC.Order.Transport;
import spring.service.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RequiredArgsConstructor
@Controller
public class Baza extends JPanel{
    int localID;
    int localListID;
    private final CustomerService customerService;
    private final GraphicService graphicService;
    private final ComputerCaseService computerCaseService;
    private final RamService ramService;
    private final MotherBoardService motherBoardService;
    private final MemoryDiscService memoryDiscService;
    private final CoolerService coolerService;
    private final PowerSupplyService powerSupplyService;
    private final ProcesorService procesorService;
    int total = 0;
    Set<PowerSupply> listPowerSupply = new HashSet<>();
    Set<Cooler> listCooler = new HashSet<>();
    Set<MotherBord> listMotherBoard = new HashSet<>();
    Set<Graphic> listGraphic = new HashSet<>();
    Set<ComputerCase> listComputerCase = new HashSet<>();
    Set<Procesor> listProcessor = new HashSet<>();
    Set<MemoryDisc> listMemoryDisc = new HashSet<>();
    List<PeCet> set = new ArrayList<>();
    Set<Ram> listRam = new HashSet<>();
    Graphic geForce = new Graphic();
    List<Customer>customerList = new ArrayList<>();
    Set<Transport>transportSet = new HashSet<>();
String Ok="Yes";
String Not="No";
String COk ="background-color:DodgerBlue;";
String CNot = "background-color:Tomato;";





    @RequestMapping("/")
    public String indexGet(){

        return "main";
}

    @RequestMapping("/deleteRepository")
    public String deleteRepository(){
        transportSet.clear();
        graphicService.delete();
        coolerService.delete();
        computerCaseService.delete();
        memoryDiscService.delete();
        motherBoardService.delete();
        powerSupplyService.delete();
        procesorService.delete();
        ramService.delete();
        return "main";
    }

    @RequestMapping("/addRepository")
    public String addRepository() throws IOException {
        Transport paczkomat = new Transport();
        paczkomat.setName("InPost");
        paczkomat.setPrice(10);
        transportSet.add(paczkomat);

        Transport kurier = new Transport();
        kurier.setPrice(15);
        kurier.setName("DHL");
transportSet.add(kurier);

        Graphic geForce = new Graphic();
        geForce.setPrice(1500);
        geForce.setName("GTX1060");
        geForce.setItem(0);
//        listGraphic.add(geForce);
        geForce.setPhotoLink("images/Karta.jpg");
//        Image img = ImageIO.read(new URL("https://s12emagst.akamaized.net/products/24710/24709875/images/res_9c6f995918fa4fdfe0a9405da95c3800_full.jpg"));
//        ImageIcon photo = new ImageIcon(img);
//        geForce.setPhoto(photo);
        graphicService.save(geForce);

        Procesor intel = new Procesor();
        intel.setName("i5");
        intel.setPrice(500);
        intel.setItem(2);
        intel.setPhotoLink("images/Intel-i5-9400F.jpg");
        procesorService.save(intel);

        ComputerCase silentium = new ComputerCase();
        silentium.setName("Silentiumpc Signum Sg1v Evo Tg");
        silentium.setPrice(250);
        silentium.setItem(3);
        silentium.setPhotoLink("images/Silentiumpc-signum-sg1v-evo-tg.jpg");
        computerCaseService.save(silentium);

        Ram RamHyperXFury = new Ram();
        RamHyperXFury.setName("HyperX Predator DDR4 8GB 3200MHz");
        RamHyperXFury.setPrice(250);
        RamHyperXFury.setItem(4);
        RamHyperXFury.setPhotoLink("images/HyperX-Predator-DDR4-8GB-3200MHz.jpg");
        ramService.save(RamHyperXFury);

        MotherBord AsusRogStrix = new MotherBord();
        AsusRogStrix.setName("Asus Rog Strix b450 f gaming");
        AsusRogStrix.setItem(5);
        AsusRogStrix.setPrice(750);
        AsusRogStrix.setPhotoLink("images/Asus-Rog-Strix-b450-f-gaming.jpg");
        motherBoardService.save(AsusRogStrix);

        MemoryDisc KingstonSSD = new MemoryDisc();
        KingstonSSD.setName("Kingston KC600 512GB SSD");
        KingstonSSD.setItem(6);
        KingstonSSD.setPrice(360);
        KingstonSSD.setPhotoLink("images/Kingston-KC600-512GB-SSD.jpg");
        memoryDiscService.save(KingstonSSD);

        Cooler BeQuietDark = new Cooler();
        BeQuietDark.setItem(7);
        BeQuietDark.setName("BE QUIET! Dark Rock PRO 4");
        BeQuietDark.setPhotoLink("images/BE-QUIET!-Dark-Rock-PRO-4.jpg");
        BeQuietDark.setPrice(350);
        coolerService.save(BeQuietDark);

        PowerSupply BeQuietPower = new PowerSupply();
        BeQuietPower.setItem(8);
        BeQuietPower.setName("Be Quiet Pure Power 11 600W");
        BeQuietPower.setPhotoLink("images/Be-Quiet-Pure-Power-11-600W.jpg");
        BeQuietPower.setPrice(450);
        powerSupplyService.save(BeQuietPower);

        return "main";
    }


    @RequestMapping("/viewComponets")
    public String viewComponents(Model model) {

        model.addAttribute("graphic",Not);
        model.addAttribute("processor",Not);
        model.addAttribute("case",Not);
        model.addAttribute("ram",Not);
        model.addAttribute("motherBoard",Not);
        model.addAttribute("memoryDisc",Not);
        model.addAttribute("cooler",Not);
        model.addAttribute("powerSupply",Not);
        for (PeCet item:set
             ) {
            System.out.println(item.item);
            switch (item.getItem()){
            case 2:
                model.addAttribute("processor",Ok);
                break;
                case 0:
                    model.addAttribute("graphic",Ok);
                    break;
                case 3:
                    model.addAttribute("case",Ok);
                    break;
                case 4:
                    model.addAttribute("ram",Ok);
                    break;
                case 5:
                    model.addAttribute("motherBoard",Ok);
                    break;
                case 6:
                    model.addAttribute("memoryDisc",Ok);
                    break;
                case 7:
                    model.addAttribute("cooler",Ok);
                    break;
                case 8:
                    model.addAttribute("powerSupply",Ok);
                    break;
        }}

        return "addComponent";
    }

    @RequestMapping("/viewGraphic")
    public String viewListGrpahic(Model model) {
        model.addAttribute("list", getGraphicList());
        model.addAttribute("dodaj","/dodajGraphic");

        return "listComputerCase";
    }

    @RequestMapping("/viewProcesor")
    public String viewListProcesor(Model model) {
        model.addAttribute("list", getListProcesor());
        model.addAttribute("dodaj","/dodajProcesor");

        return "listComputerCase";
    }

    @RequestMapping("/viewComputerCase")
    public String viewListComputerCase(Model model) {
        model.addAttribute("list", getComputerCaseList());
        model.addAttribute("dodaj","/dodajComputerCase");

        return "listComputerCase";
    }

    @RequestMapping("/viewRamCase")
    public String viewListRam(Model model) {
        model.addAttribute("list", getRamList());
        model.addAttribute("dodaj","/dodajRam");

        return "listComputerCase";
    }

    @RequestMapping("/viewMotherBoard")
    public String viewListMotherBoard(Model model) {
        model.addAttribute("list", getMotherBoardList());
        model.addAttribute("dodaj","/dodajMotherBoard");

        return "listComputerCase";
    }

    @RequestMapping("/viewMemoryDisc")
    public String viewListMemoryDisc(Model model) {
        model.addAttribute("list", getListMemoryDisc());
        model.addAttribute("dodaj","/dodajMemoryDisc");

        return "listComputerCase";
    }
    @RequestMapping("/viewCooler")
    public String viewListCooler(Model model) {
        model.addAttribute("list", getListCooler());
        model.addAttribute("dodaj","/dodajCooler");

        return "listComputerCase";
    }
    @RequestMapping("/viewPowerSupply")
    public String viewListPowerSupply(Model model) {
        model.addAttribute("list", getListPowerSupply());
        model.addAttribute("dodaj","/dodajPowerSupply");

        return "listComputerCase";
    }

    @RequestMapping(value = "/index")
    public ModelAndView menu(Model model){return new ModelAndView("main");}

    @RequestMapping(value = "/dodajGraphic", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam(value = "geForce.name") String name) {
        Graphic tempEmp = null;
        listGraphic = getGraphicList();
        System.out.println(listGraphic);
        for(Graphic one : listGraphic) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajComputerCase", method = RequestMethod.POST)
    public ModelAndView addComputerCase(@RequestParam(value = "geForce.name") String name) {
        ComputerCase tempEmp = null;
        listComputerCase = getComputerCaseList();
        for(ComputerCase one : listComputerCase) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajRam", method = RequestMethod.POST)
    public ModelAndView addRam(@RequestParam(value = "geForce.name") String name) {
        Ram tempEmp = null;
        listRam = getRamList();
        for(Ram one : listRam) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajMotherBoard", method = RequestMethod.POST)
    public ModelAndView addMotherBoard(@RequestParam(value = "geForce.name") String name) {
        MotherBord tempEmp = null;
        listMotherBoard = getMotherBoardList();
        for(MotherBord one : listMotherBoard) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajMemoryDisc", method = RequestMethod.POST)
    public ModelAndView addMemoryDisc(@RequestParam(value = "geForce.name") String name) {
        MemoryDisc tempEmp = null;
        listMemoryDisc = getListMemoryDisc();
        for(MemoryDisc one : listMemoryDisc) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }
    @RequestMapping(value = "/dodajCooler", method = RequestMethod.POST)
    public ModelAndView addCooler(@RequestParam(value = "geForce.name") String name) {
        Cooler tempEmp = null;
        listCooler = getListCooler();
        for(Cooler one : listCooler) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajPowerSupply", method = RequestMethod.POST)
    public ModelAndView addPowerSupply(@RequestParam(value = "geForce.name") String name) {
        PowerSupply tempEmp = null;
        listPowerSupply = getListPowerSupply();
        for(PowerSupply one : listPowerSupply) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/dodajProcesor", method = RequestMethod.POST)
    public ModelAndView addProcesor(@RequestParam(value = "geForce.name") String name) {
        Procesor tempEmp = null;
        listProcessor = getListProcesor();
        for(Procesor one : listProcessor) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.add(tempEmp);

        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/viewSetList")
    public String viewListSet(Model model) {
        total =0;
        System.out.println(set);
        for (PeCet price:set
        ) {

            total=price.getPrice()+total;

        }
        model.addAttribute("price",total);
        model.addAttribute("list",set);

      return "listSet";
    }



    @RequestMapping(value = "/usun", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "name") String name) {
        PeCet tempEmp = null;
        for(PeCet one : set) {
            if(one.getName().equals(name)) {
                tempEmp = one;
            }
        }
        set.remove(tempEmp);
        return new ModelAndView("redirect:/viewSetList");
    }

    @RequestMapping(value = "/addDelivery", method = RequestMethod.POST)
    public ModelAndView addDelivery(@RequestParam(value = "transport") String transport) {
Customer customer = new Customer();
customer = customerList.get(localID);
Transport temp = null;
for (Transport transport1 : transportSet){
    if(transport1.getName().equals(transport)){
        temp=transport1;
    }
}
        customer.setTransport1(temp);
customer.setTransport(temp.getName());
        System.out.println(customer);
        localListID = customer.getId();
        customerList.add(customer);
        customerService.save(customer);
        localID=customer.getId();

        return new ModelAndView("redirect:/Pay");
    }



    @RequestMapping(value = "/viewDelivery")
    public String viewDelivery(Model model) {

        model.addAttribute("transport",transportSet);

        return "addDelivery";
    }


    @RequestMapping(value = "/addCustomerName", method = RequestMethod.GET)
    public String addCustomerName(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("transport",transportSet);
            return "addCustomer";
        }

    @PostMapping(value = "/addCustomer")
    public String addCustomer(Model model, @ModelAttribute @Valid Customer customer, BindingResult result){
        if (result.hasErrors()) {
            System.out.println("is error");
            System.out.println(customer);
            return "redirect:/addCustomerName";
        }

        else{
             {

            customer.setSet(set);
            customerList.add(customer);
//            customerService.save(customer);
                 localID = customer.getId();

        }}
        return "redirect:/viewDelivery";
    }
    @RequestMapping(value = "/Pay")
    public String Pay(Model model){

        System.out.println(customerService.getOne(localID));
        System.out.println("test");
        System.out.println(customerService.getSet(localID));
        System.out.println("test2");
        System.out.println(customerList);
        model.addAttribute("customer",customerService.getOne(localID));
        model.addAttribute("order",set);
        int transport = customerList.get(localListID).getTransport1().getPrice();
        total =0;
        System.out.println(set);
        for (PeCet price:set
        ) {

            total=price.getPrice()+total;

        }
        int totalSum = total+transport;
        model.addAttribute("total",total);
        model.addAttribute("deliveryCost",transport);
        model.addAttribute("totalSum",totalSum);

        return "payment";
    }
    @RequestMapping(value = "/Fianl")
    public String Final(Model model){

        int transport = customerList.get(localListID).getTransport1().getPrice();
        total =0;
        for (PeCet price:set
        ) {

            total=price.getPrice()+total;

        }
        int totalSum = total+transport;
        StringBuilder str1 = new StringBuilder();
        str1.append(totalSum);
        str1.append(" PLN");
        StringBuilder str2 = new StringBuilder();
        str2.append("Number od order: ");
        str2.append(localID);


        model.addAttribute("totalSum",str1);
        model.addAttribute("idOrder",str2);
        return "final";
    }

    @RequestMapping("/newOrder")
    public String newOrder(){
        customerList.clear();
        set.clear();
        return "main";
    }

    public Set<Graphic> getGraphicList() {
        return graphicService.getAll();
    }
    public Set<ComputerCase> getComputerCaseList() {
        return computerCaseService.getAll();
    }
    public Set<Ram> getRamList() {
        return ramService.getAll();
    }
    public Set<MotherBord> getMotherBoardList() {
        return motherBoardService.getAll();
    }
    public Set<MemoryDisc> getListMemoryDisc() {
        return memoryDiscService.getAll();
    }
    public Set<Cooler> getListCooler() {
        return coolerService.getAll();
    }
    public Set<PowerSupply> getListPowerSupply() { return powerSupplyService.getAll();}
    public Set<Procesor> getListProcesor() { return procesorService.getAll(); }

}
