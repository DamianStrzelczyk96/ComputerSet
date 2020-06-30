package spring.PC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.PC.Components.*;
import spring.PC.Order.Admin;
import spring.PC.Order.Customer;
import spring.PC.Order.Transport;
import spring.service.*;

import javax.imageio.ImageIO;
import javax.persistence.criteria.CriteriaBuilder;
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
    String localName;
    private final ComputerService computerService;
    private final PeCetService peCetService;
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
    List<PeCet>peCetList = new ArrayList<>();
    Set<SetSugestion>setSugestions = new HashSet<>();
String Ok="Yes";
String Not="No";
String COk ="background-color:DodgerBlue;";
String CNot = "background-color:Tomato;";





    @RequestMapping("/")
    public String indexGet(){

        return "main";
}

    @RequestMapping("/addDetalis")
    public String addDetalis(){
        SetSugestion Gaming = new SetSugestion();
        Gaming.setName("gaming");
        Gaming.setPrice(10000);
        setSugestions.add(Gaming);

        SetSugestion Prgraming = new SetSugestion();
        Prgraming.setPrice(4700);
        Prgraming.setName("programing");
        setSugestions.add(Prgraming);

        Transport paczkomat = new Transport();
        paczkomat.setName("InPost");
        paczkomat.setPrice(10);
        transportSet.add(paczkomat);

        Transport kurier = new Transport();
        kurier.setPrice(15);
        kurier.setName("DHL");
        transportSet.add(kurier);

        return "adminPanel";
    }

    @RequestMapping("/addRepository")
    public String addRepository() throws IOException {


        Graphic geForce = new Graphic();
        geForce.setPrice(1500);
        geForce.setName("GTX1060");
        geForce.setItem(0);
//        listGraphic.add(geForce);
        geForce.setPhotoLink("images/graphic/Karta.jpg");
//        Image img = ImageIO.read(new URL("https://s12emagst.akamaized.net/products/24710/24709875/images/res_9c6f995918fa4fdfe0a9405da95c3800_full.jpg"));
//        ImageIcon photo = new ImageIcon(img);
//        geForce.setPhoto(photo);
        graphicService.save(geForce);

        Graphic RTX2080 = new Graphic();
        RTX2080.setPrice(3600);
        RTX2080.setItem(0);
        RTX2080.setName("RTX2080 SUPER");
        RTX2080.setPhotoLink("images/graphic/RTX2080SUPER.jpg");
        graphicService.save(RTX2080);

        Graphic MSIRadeonRX5700GAMINGX8GBGDDR6 = new Graphic();
        MSIRadeonRX5700GAMINGX8GBGDDR6.setName("MSI Radeon RX 5700 GAMING X 8GB GDDR6");
        MSIRadeonRX5700GAMINGX8GBGDDR6.setPrice(1800);
        MSIRadeonRX5700GAMINGX8GBGDDR6.setItem(0);
        MSIRadeonRX5700GAMINGX8GBGDDR6.setPhotoLink("images/graphic/MSI-Radeon-RX-5700-GAMING-X-8GB.jpg");
        graphicService.save(MSIRadeonRX5700GAMINGX8GBGDDR6);



        Procesor AMDRyzen53600 = new Procesor();
        AMDRyzen53600.setName("AMD Ryzen 5 3600");
        AMDRyzen53600.setPrice(850);
        AMDRyzen53600.setItem(0);
        AMDRyzen53600.setPhotoLink("images/procesor/AMD-Ryzen-5-3600.jpg");
        procesorService.save(AMDRyzen53600);

        Procesor intel = new Procesor();
        intel.setName("i5");
        intel.setPrice(500);
        intel.setItem(2);
        intel.setPhotoLink("images/procesor/Intel-i5-9400F.jpg");
        procesorService.save(intel);

        Procesor intelI79700K = new Procesor();
        intelI79700K.setItem(2);
        intelI79700K.setPrice(1800);
        intelI79700K.setName("Intel i7 9700K 3.6GHz 12MB");
        intelI79700K.setPhotoLink("images/procesor/Intel-i7-9700K-3.6GHz-12MB.jpg");
        procesorService.save(intelI79700K);

        ComputerCase silentium = new ComputerCase();
        silentium.setName("Silentiumpc Signum Sg1v Evo Tg");
        silentium.setPrice(250);
        silentium.setItem(3);
        silentium.setPhotoLink("images/computerCase/Silentiumpc-signum-sg1v-evo-tg.jpg");
        computerCaseService.save(silentium);

        ComputerCase SilentiumPCRegnumRG6VTGPureBlack = new ComputerCase();
        SilentiumPCRegnumRG6VTGPureBlack.setItem(3);
        SilentiumPCRegnumRG6VTGPureBlack.setPrice(300);
        SilentiumPCRegnumRG6VTGPureBlack.setName("SilentiumPC Regnum RG6V TG Pure Black");
        SilentiumPCRegnumRG6VTGPureBlack.setPhotoLink("images/computerCase/SilentiumPC-Regnum-RG6V-TG-Pure-Black.jpg");
        computerCaseService.save(SilentiumPCRegnumRG6VTGPureBlack);


        ComputerCase BeQuietSilentBase601 = new ComputerCase();
        BeQuietSilentBase601.setPhotoLink("images/computerCase/Be-Quiet!-Silent-Base-601.jpg");
        BeQuietSilentBase601.setItem(3);
        BeQuietSilentBase601.setPrice(550);
        BeQuietSilentBase601.setName("Be Quiet! Silent Base 601");
        computerCaseService.save(BeQuietSilentBase601);


        Ram HyperX16GB2x8GB2666MHzCL16Fury = new Ram();
        HyperX16GB2x8GB2666MHzCL16Fury.setPrice(350);
        HyperX16GB2x8GB2666MHzCL16Fury.setName("HyperX 16GB (2x8GB) 2666MHz CL16 Fury");
        HyperX16GB2x8GB2666MHzCL16Fury.setItem(4);
        HyperX16GB2x8GB2666MHzCL16Fury.setPhotoLink("images/ram/HyperX-16GB-2x8GB-2666MHz-CL16-Fury.jpg");
        ramService.save(HyperX16GB2x8GB2666MHzCL16Fury);

        Ram RamHyperXFury = new Ram();
        RamHyperXFury.setName("HyperX Predator DDR4 8GB 3200MHz");
        RamHyperXFury.setPrice(250);
        RamHyperXFury.setItem(4);
        RamHyperXFury.setPhotoLink("images/ram/HyperX-Predator-DDR4-8GB-3200MHz.jpg");
        ramService.save(RamHyperXFury);

        Ram Inno3D16GB = new Ram();
        Inno3D16GB.setItem(4);
        Inno3D16GB.setName("Inno3D 16GB 3600MHz iCHILL RGB CL17");
        Inno3D16GB.setPhotoLink("images/ram/Inno3D-16GB-3600MHz.jpg");
        Inno3D16GB.setPrice(1000);
        ramService.save(Inno3D16GB);

        MotherBord AsusRogStrix = new MotherBord();
        AsusRogStrix.setName("Asus Rog Strix b450 f gaming");
        AsusRogStrix.setItem(5);
        AsusRogStrix.setPrice(750);
        AsusRogStrix.setPhotoLink("images/motherBoard/Asus-Rog-Strix-b450-f-gaming.jpg");
        motherBoardService.save(AsusRogStrix);

        MotherBord ASRockFatal1tyB450 = new MotherBord();
        ASRockFatal1tyB450.setName("ASRock Fatal1ty B450 Gaming K4");
        ASRockFatal1tyB450.setPhotoLink("images/motherBoard/ASRock-Fatal1ty-B450-Gaming-K4.jpg");
        ASRockFatal1tyB450.setPrice(500);
        ASRockFatal1tyB450.setItem(5);
        motherBoardService.save(ASRockFatal1tyB450);

        MotherBord GigabyteZ390 = new MotherBord();
        GigabyteZ390.setPrice(1000);
        GigabyteZ390.setItem(5);
        GigabyteZ390.setName("Gigabyte Z390 Aorus pro");
        GigabyteZ390.setPhotoLink("images/motherBoard/Gigabyte-Z390-Aorus-pro.jpg");
        motherBoardService.save(GigabyteZ390);


        MemoryDisc KingstonSSD = new MemoryDisc();
        KingstonSSD.setName("Kingston KC600 512GB SSD");
        KingstonSSD.setItem(6);
        KingstonSSD.setPrice(360);
        KingstonSSD.setPhotoLink("images/memoryDisc/Kingston-KC600-512GB-SSD.jpg");
        memoryDiscService.save(KingstonSSD);

        MemoryDisc AdataSSD512GB = new MemoryDisc();
        AdataSSD512GB.setPhotoLink("images/memoryDisc/Adata-ssd-512GB.jpg");
        AdataSSD512GB.setPrice(600);
        AdataSSD512GB.setItem(6);
        AdataSSD512GB.setName("Adata SU900 SSD 512GB");
        memoryDiscService.save(AdataSSD512GB);

        Cooler BeQuietDark = new Cooler();
        BeQuietDark.setItem(7);
        BeQuietDark.setName("BE QUIET! Dark Rock PRO 4");
        BeQuietDark.setPhotoLink("images/cooler/BE-QUIET!-Dark-Rock-PRO-4.jpg");
        BeQuietDark.setPrice(350);
        coolerService.save(BeQuietDark);

        Cooler 	SilentiumPCSpartan4Max120mm = new Cooler();
        SilentiumPCSpartan4Max120mm.setName("SilentiumPC Spartan 4 Max 120mm");
        SilentiumPCSpartan4Max120mm.setItem(7);
        SilentiumPCSpartan4Max120mm.setPrice(100);
        SilentiumPCSpartan4Max120mm.setPhotoLink("images/cooler/SilentiumPC-Spartan-4-Max-120mm.jpg");
        coolerService.save(SilentiumPCSpartan4Max120mm);

        Cooler SilentLoop360 = new Cooler();
        SilentLoop360.setPrice(700);
        SilentLoop360.setPhotoLink("images/cooler/Silent-Loop-360mm.jpg");
        SilentLoop360.setName("BE Quiet! Silent Loop 360mm");
        SilentLoop360.setItem(7);
        coolerService.save(SilentLoop360);

        PowerSupply BeQuietPower = new PowerSupply();
        BeQuietPower.setItem(8);
        BeQuietPower.setName("Be Quiet Pure Power 11 600W");
        BeQuietPower.setPhotoLink("images/powerSupply/Be-Quiet-Pure-Power-11-600W.jpg");
        BeQuietPower.setPrice(450);
        powerSupplyService.save(BeQuietPower);

        PowerSupply SilentiumPCSupremoL2650W80PlusGold = new PowerSupply();
        SilentiumPCSupremoL2650W80PlusGold.setName("SilentiumPC Supremo L2 650W 80 Plus Gold");
        SilentiumPCSupremoL2650W80PlusGold.setPrice(380);
        SilentiumPCSupremoL2650W80PlusGold.setItem(8);
        SilentiumPCSupremoL2650W80PlusGold.setPhotoLink("images/powerSupply/SilentiumPC-Supremo-L2-650W-80-Plus-Gold.jpg");
        powerSupplyService.save(SilentiumPCSupremoL2650W80PlusGold);

        PowerSupply BeQuietStraightPower11 = new PowerSupply();
        BeQuietStraightPower11.setPrice(550);
        BeQuietStraightPower11.setPhotoLink("images/powerSupply/Be-Quiet!-Straight-Power-11-650W.jpg");
        BeQuietStraightPower11.setItem(8);
        BeQuietStraightPower11.setName("Be Quiet! Straight Power11 650W");
        powerSupplyService.save(BeQuietStraightPower11);
        return "adminPanel";
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
        setSugestions.clear();
        return "adminPanel";
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

    @RequestMapping("/viewSetSugestion")
    public String viewSetSugestion(Model model){
        model.addAttribute ("list",setSugestions);

        return "setSugesstion";
    }

    @PostMapping(value = "/save_set")
    public String saveCar(Model model, @ModelAttribute(value = "setSugestion") String name){
        listGraphic = getGraphicList();
        listComputerCase = getComputerCaseList();
        listRam = getRamList();
        listCooler = getListCooler();
        listMotherBoard = getMotherBoardList();
        listPowerSupply = getListPowerSupply();
        listProcessor = getListProcesor();
        listMemoryDisc = getListMemoryDisc();

        if (name.equals("gaming")){

            add("RTX2080 SUPER");
            addComputerCase("Be Quiet! Silent Base 601");
            addProcesor("Intel i7 9700K 3.6GHz 12MB");
            addCooler("BE Quiet! Silent Loop 360mm");
            addMemoryDisc("Adata SU900 SSD 512GB");
            addMotherBoard("Gigabyte Z390 Aorus pro");
            addPowerSupply("Be Quiet! Straight Power11 650W");
            addRam("Inno3D 16GB 3600MHz iCHILL RGB CL17");
        }
        if (name.equals("programing")){

            add("MSI Radeon RX 5700 GAMING X 8GB GDDR6");
            addProcesor("AMD Ryzen 5 3600");
            addComputerCase("SilentiumPC Regnum RG6V TG Pure Black");
            addPowerSupply("SilentiumPC Supremo L2 650W 80 Plus Gold");
            addRam("HyperX 16GB (2x8GB) 2666MHz CL16 Fury");
            addMotherBoard("ASRock Fatal1ty B450 Gaming K4");
            addCooler("SilentiumPC Spartan 4 Max 120mm");
            addMemoryDisc("Kingston KC600 512GB SSD");
        }


        return "redirect:/viewSetList";
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

    @RequestMapping("/clearSet")
    public String clearSet(Model model) {
        set.clear();

        return "redirect:/viewSetList";
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
        for (Customer cust:customerList
        ) {if(cust.getId() == localID){
            customer = cust;
        }};
        System.out.println("delivery");
        System.out.println(customer);
Transport temp = null;
for (Transport transport1 : transportSet){
    if(transport1.getName().equals(transport)){
        temp=transport1;
    }
}
        customer.setTransport1(temp);
customer.setTransport(temp.getName());
        customerList.add(localID,customer);
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
            return "redirect:/addCustomerName";
        }

        else{
             {
                 System.out.println(customer);
                 System.out.println("customer add");
                 System.out.println(customer.getId());
            customerList.add(customer);
                 localID = customer.getId();
                 System.out.println(customer.getId());
                 localName = customer.getName();

        }}
        return "redirect:/viewDelivery";
    }
    @RequestMapping(value = "/Pay")
    public String Pay(Model model){

        Customer customer = new Customer();



        int transport = 0;
        for (Customer cust:customerList
             ) {if(cust.getId() == localID){
                 customer = cust;
                 transport = cust.getTransport1().getPrice();
        }

        }

        total =0;
        System.out.println("finall custoemr");
        System.out.println(customer);
        for (PeCet price:set
        ) {

            total=price.getPrice()+total;

        }
        int totalSum = total+transport;

        customer.setTotalPrice(totalSum);
localID = customer.getId();

        model.addAttribute("customer",customer);
        model.addAttribute("order",set);
        model.addAttribute("total",total);
        model.addAttribute("deliveryCost",transport);
        model.addAttribute("totalSum",totalSum);

        return "payment";
    }
    @RequestMapping(value = "/Fianl")
    public String Final(Model model){
Customer customer = new Customer();
        for (Customer cust:customerList
        ) {if(cust.getId() == localID){
            customer = cust;
        }

        }
        customerService.save(customer);
        System.out.println(customer);
        System.out.println(customerService.getAll());
        localID = customer.getId();

        int totalSum = customer.getTotalPrice();

        StringBuilder str1 = new StringBuilder();
        str1.append(totalSum);
        str1.append(" PLN");
        StringBuilder str2 = new StringBuilder();
        str2.append("Number of order: ");
        str2.append(localID);


        model.addAttribute("totalSum",str1);
        model.addAttribute("idOrder",str2);

        for (PeCet pecet:set
             ) {

            computerService.save(pecet,localID,localName);
        }
        System.out.println(computerService.getAll());
        customerList.clear();
        set.clear();
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


    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String addAdmin(Model model){
        model.addAttribute("admin", new Admin());
        return "adminLogin";
    }
    @PostMapping(value = "/adminLogin")
    public String adminLogin(Model model, @ModelAttribute @Valid Admin admin, BindingResult result){
        if (result.hasErrors()) {
            System.out.println("is error");
            return "redirect:/addAdmin";
        }

        if(admin.getName().equals("admin")&&admin.getPassword().equals("admin")){
            return "adminPanel";



    }
        return "redirect:/addAdmin";
    }
}
