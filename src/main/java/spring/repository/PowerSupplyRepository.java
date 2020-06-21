package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.PowerSupply;
import spring.PC.Components.Ram;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Integer> {
}
