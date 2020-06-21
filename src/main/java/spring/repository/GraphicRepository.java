package spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.Graphic;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Integer> {

}
