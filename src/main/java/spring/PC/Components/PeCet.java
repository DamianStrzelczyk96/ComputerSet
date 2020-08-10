package spring.PC.Components;

import lombok.*;
import org.springframework.context.annotation.Primary;
import spring.PC.Order.Customer;

import javax.persistence.*;
import javax.swing.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeCet {
    @Id
    @GeneratedValue
    private int id;
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
