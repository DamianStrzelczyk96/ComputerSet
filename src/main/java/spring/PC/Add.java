package spring.PC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.PC.Components.*;
import spring.PC.Order.Transport;
import spring.service.*;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class Add {
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

}
