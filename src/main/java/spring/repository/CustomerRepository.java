package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.PC.Order.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
