package spring.PC.Order;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;




public class  Transport {
    String name;
    int price;

public void setName(String name){this.name=name;}
public void setPrice(int price){this.price=price;}
public  String getName(){return name;}
public int getPrice(){return price;}

    @Override
    public String toString() {
        return  name ;

    }
}
