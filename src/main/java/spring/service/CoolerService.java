package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.Cooler;
import spring.PC.Components.Graphic;
import spring.repository.CoolerRepositroy;
import spring.repository.GraphicRepository;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CoolerService {
    private final CoolerRepositroy repository;

    public void delete(){repository.deleteAll();}
    public void save(final Cooler cooler) {
        repository.save(cooler);
    }

    public Set<Cooler> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
