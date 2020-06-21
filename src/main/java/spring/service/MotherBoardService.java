package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.ComputerCase;
import spring.PC.Components.MotherBord;
import spring.repository.ComputerCaseRepository;
import spring.repository.MotherBordRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotherBoardService {


    private final MotherBordRepository repository;
    public void delete(){repository.deleteAll();}

    public void save(final MotherBord motherBord) {
        repository.save(motherBord);
    }

    public Set<MotherBord> getAll() {

        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
