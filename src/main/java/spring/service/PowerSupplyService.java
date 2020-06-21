package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.MotherBord;
import spring.PC.Components.PowerSupply;
import spring.repository.MotherBordRepository;
import spring.repository.PowerSupplyRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PowerSupplyService  {

    private final PowerSupplyRepository repository;
    public void delete(){repository.deleteAll();}

    public void save(final PowerSupply powerSupply) {
        repository.save(powerSupply);
    }

    public Set<PowerSupply> getAll() {

        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
