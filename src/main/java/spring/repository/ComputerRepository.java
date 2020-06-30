package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.Computer;
import spring.PC.Components.PeCet;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
