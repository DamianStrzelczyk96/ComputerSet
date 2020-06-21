package spring.PC.Components;

import lombok.EqualsAndHashCode;

import javax.swing.*;

public abstract class PeCet {
    @EqualsAndHashCode.Exclude
   public int price;
    @EqualsAndHashCode.Exclude
  public  String name;
  public  int item;
    ImageIcon photo;
   public String photoLink;

public  String getPhotoLink(){return photoLink;}
    public int getItem(){
        return item;
    }
public String getName(){
    return name;
}
    public int getPrice() {
        return price;
    }

}
