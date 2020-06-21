package spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.Graphic;
import spring.repository.GraphicRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GraphicService {

    private final GraphicRepository repository;


    public void save(final Graphic graphic) {
        repository.save(graphic);
    }

    public Set<Graphic> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
