package spring.PC.Components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cooler extends PeCet {

    @Id
    @GeneratedValue
    private int id;
    private int price;
    private String name;
    private int item;
    private String photoLink;
    @Column
    @Lob
    private ImageIcon photo;

 /*   public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setPhotoLink(String photoLink){this.photoLink = photoLink;}
    public String getPhotoLink(){return photoLink; }
    public String getName() {
        return name;
    }
    public void setPhoto(ImageIcon photo){ this.photo = photo;}
    public void setName(String name) {
        this.name = name;
    }
    public void setItem(int item) {this.item = item;
    }
    public int getItem() {
        return item;
    }*/

/*    @Override
    public String toString() {
        return "spring.spring.PC.PC.pc.Graphic{" +
                "price=" + price +
                ", name='" + name + '\'' + "photo= " + photo +
                '}';
    }*/
}
