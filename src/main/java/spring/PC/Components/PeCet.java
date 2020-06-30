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

    //TODO nazwa zestawu
    @EqualsAndHashCode.Exclude
   public int price;
    @EqualsAndHashCode.Exclude
  public  String name;
  public  int item;
    ImageIcon photo;
   public String photoLink;
//
//    @ManyToOne
//    @JoinColumn
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @NonNull
//   public Customer customer;


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
