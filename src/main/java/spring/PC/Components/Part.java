package spring.PC.Components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    private int id;
    private double pricePart;
    private String brand;
    private String model;
    private String nameImg;
}
