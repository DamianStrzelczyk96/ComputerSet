package spring.PC.Order;


import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import spring.PC.Components.Graphic;
import spring.PC.Components.PeCet;
import spring.PC.Components.Ram;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String name;
    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String surName;
    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String adress;
    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String email;
 private String transport;

 private int totalPrice;

  private transient Transport transport1;


    private int telephone;




    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", set=" +  ", transport=" + transport+ " totalPrice: " +
                '}';
    }
}
