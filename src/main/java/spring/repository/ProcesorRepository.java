package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.PowerSupply;
import spring.PC.Components.Procesor;

@Repository
public interface ProcesorRepository extends JpaRepository<Procesor, Integer> {
}
