package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Components.Graphic;
import spring.PC.Components.MemoryDisc;

@Repository
public interface MemoryDiscRepository extends JpaRepository<MemoryDisc, Integer> {
}
