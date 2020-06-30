package spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.Graphic;
import spring.PC.Order.Customer;
import spring.repository.CustomerRepository;
import spring.repository.GraphicRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void delete(){repository.deleteAll();}
    public void save(final Customer customer) {
        repository.save(customer);
    }

    public Customer getOne(int id){
        return repository.getOne(id);
    }
//    public List getSet(int id){
//        return repository.getOne(id).getSet();
//    }

    public List<Customer> getAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
