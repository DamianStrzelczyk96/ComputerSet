package spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.ComputerCase;
import spring.PC.Components.Graphic;
import spring.repository.ComputerCaseRepository;
import spring.repository.GraphicRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputerCaseService {
    private final ComputerCaseRepository repository;


    public void save(final ComputerCase ComputerCase) {
        repository.save(ComputerCase);
    }

    public Set<ComputerCase> getAll() {

        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
