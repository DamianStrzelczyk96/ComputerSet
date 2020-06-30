package spring.PC.Components;

import lombok.*;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Procesor extends PeCet {
    @Id
    @GeneratedValue
    private int id;
    int price;
    String name;
    int item;
    String photoLink;
    @Column
    @Lob
    ImageIcon photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPhotoLink(String photoLink){this.photoLink = photoLink;}
    public String getPhotoLink(){return photoLink; }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setItem(int item) {this.item = item; }
    public int getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "spring.spring.PC.PC.pc.Procesor{" +
                "name='" + name + '\'' +
                ", pirce=" + price +
                '}';
    }
}
