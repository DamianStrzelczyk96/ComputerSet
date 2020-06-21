package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.MemoryDisc;
import spring.PC.Components.MotherBord;
import spring.repository.MemoryDiscRepository;
import spring.repository.MotherBordRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemoryDiscService {

    private final MemoryDiscRepository repository;

    public void delete(){repository.deleteAll();}
    public void save(final MemoryDisc memoryDisc) {
        repository.save(memoryDisc);
    }

    public Set<MemoryDisc> getAll() {

        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
