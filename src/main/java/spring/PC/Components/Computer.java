package spring.PC.Components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    private int id;
    private String name;
    private Procesor procesor;
    private Cooler cooler;
    private Ram ram;
    private MemoryDisc memoryDisc;
    private PowerSupply powerSupply;
    private Graphic graphic;
}
