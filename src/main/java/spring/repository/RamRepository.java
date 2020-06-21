package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.ComputerCase;
import spring.PC.Components.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram, Integer> {
}
