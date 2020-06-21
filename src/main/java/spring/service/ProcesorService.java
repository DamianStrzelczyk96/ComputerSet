package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.PowerSupply;
import spring.PC.Components.Procesor;
import spring.repository.PowerSupplyRepository;
import spring.repository.ProcesorRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcesorService {
    private final ProcesorRepository repository;


    public void save(final Procesor procesor) {
        repository.save(procesor);
    }

    public Set<Procesor> getAll() {

        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
