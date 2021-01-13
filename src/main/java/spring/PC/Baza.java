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
import javax.mail.MessagingException;
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

    @RequestMapping("/deleteRepository")
    public String deleteRepository(){
        graphicService.delete();
        coolerService.delete();
        computerCaseService.delete();
        memoryDiscService.delete();
        motherBoardService.delete();
        powerSupplyService.delete();
        procesorService.delete();
        ramService.delete();
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

        setSugestions.clear();

        SetSugestion Gaming = new SetSugestion();
        Gaming.setName("gaming");
        Gaming.setPrice(10000);
        setSugestions.add(Gaming);

        SetSugestion Prgraming = new SetSugestion();
        Prgraming.setPrice(4700);
        Prgraming.setName("programing");
        setSugestions.add(Prgraming);

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
        transportSet.clear();
        Transport paczkomat = new Transport();
        paczkomat.setName("InPost");
        paczkomat.setPrice(10);
        transportSet.add(paczkomat);

        Transport kurier = new Transport();
        kurier.setPrice(15);
        kurier.setName("DHL");
        transportSet.add(kurier);

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
        transportSet.clear();
        Transport paczkomat = new Transport();
        paczkomat.setName("InPost");
        paczkomat.setPrice(10);
        transportSet.add(paczkomat);

        Transport kurier = new Transport();
        kurier.setPrice(15);
        kurier.setName("DHL");
        transportSet.add(kurier);
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
    public String Final(Model model) throws MessagingException {
Customer customer = new Customer();
        for (Customer cust:customerList
        ) {if(cust.getId() == localID){
            customer = cust;
        }}


int totalSum = customer.getTotalPrice();

        customerService.save(customer);
        System.out.println(customer);
        System.out.println(customerService.getAll());
        localID = customer.getId();


        StringBuilder str1 = new StringBuilder();
        str1.append(totalSum);
        str1.append(" PLN");
        StringBuilder str2 = new StringBuilder();
        str2.append("Number of order: ");
        str2.append(localID);


        model.addAttribute("totalSum",str1);
        model.addAttribute("idOrder",str2);
        StringBuilder content = new StringBuilder();
        content.append("Yours order is: ");
        content.append("\n");
        int number = 0;
        for (PeCet pecet:set
             ) {
            number = number + 1;
content.append(number + ". : " + pecet.getName());
            content.append("\n");

            computerService.save(pecet,localID,localName);
        }
        StringBuilder subject = new StringBuilder();
        subject.append("Numer zamówienie: ");
        subject.append(customer.getId());

        String subjectString = subject.toString();

        content.append("\n");
        content.append("Total cost of Your order is: ");
        content.append(customer.getTotalPrice());
        content.append("\n");
        content.append("Please do not send this money on my account !");
        String contentString = content.toString(); 


//        EmailSender emailSender = new EmailSender();
//        emailSender.SendEmail(customer.getEmail(),subjectString,contentString);

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

        if(admin.getName().equals("admin")&&admin.getPassword().equals("adminadmin")){
            return "adminPanel";



    }
        return "redirect:/addAdmin";
    }
}
