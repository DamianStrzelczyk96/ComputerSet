import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PC {
    int price;
    String name;
       public void procesor(int price, String name){
        this.name=name;
        this.price=price;
    }
    public void graphic(int price, String name){
        this.name=name;
        this.price=price;
    }

}
