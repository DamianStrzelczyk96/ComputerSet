package spring.PC.Order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @NotEmpty
    String name;
    @NotEmpty
    String password;
}
