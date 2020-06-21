package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.ComputerCase;
import spring.PC.Components.Ram;
import spring.repository.RamRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RamService {
    private final RamRepository repository;


    public void save(final Ram ram) {
        repository.save(ram);
    }

    public Set<Ram> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }


}
