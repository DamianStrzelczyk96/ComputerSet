package spring.PC.Components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.*;
import java.util.List;
@Entity
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue
    private int id;
    @EqualsAndHashCode.Exclude
    public  int customerID;
    @EqualsAndHashCode.Exclude
    public String customerName;
    @EqualsAndHashCode.Exclude
    public int price;
    @EqualsAndHashCode.Exclude
    public  String name;
    public  int item;
}
