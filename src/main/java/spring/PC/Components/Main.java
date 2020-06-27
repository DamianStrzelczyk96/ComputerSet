package spring.PC.Components;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //PODEJSCIE 1
        Computer computer = new Computer();
        computer.setId(1);
        computer.setNamePC("PCMASTERRACE");
        computer.setPriceOfPC(5100);

        Part grafika = new Part();
        grafika.setBrand("MSI");
        grafika.setModel("RTX2080");
        grafika.setNameImg("asd.jpgh");
        grafika.setPricePart(2200);

        Part procesor = new Part();
        procesor.setBrand("Intel");
        procesor.setModel("i9");
        procesor.setNameImg("asd123.jpgh");
        procesor.setPricePart(2000);

        List<Part> partList = new ArrayList<>();
        partList.add(grafika);
        partList.add(procesor);

        computer.setPartList(partList);

        System.out.println(computer);


        //PODEJSCIE 2
        Computer2 computer2 = new Computer2();
        computer2.setId(1);
        computer2.setCooler(new Cooler());
        computer2.setGraphic(new Graphic());

        System.out.println(computer2);


    }
}
