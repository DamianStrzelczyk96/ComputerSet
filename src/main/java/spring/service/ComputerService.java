package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.Computer;
import spring.PC.Components.PeCet;
import spring.repository.ComputerRepository;
import spring.repository.PeCetRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository repository;
    public void delete(){repository.deleteAll();}

    public void save(final PeCet peCet, int id , String name) {
        Computer computer = new Computer();
        computer.setCustomerID(id);
        computer.setItem(peCet.getItem());
        computer.setName(peCet.getName());
        computer.setPrice(peCet.getPrice());
        computer.setCustomerName(name);
        repository.save(computer);


    }

    public List<Computer> getAll() {

        return repository.findAll().stream().collect(Collectors.toList());
    }
}
