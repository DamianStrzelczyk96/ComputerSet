package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.ComputerCase;

@Repository
public interface ComputerCaseRepository extends JpaRepository<ComputerCase, Integer> {
}
