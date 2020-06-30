package spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.PC.Components.PeCet;
import spring.PC.Components.PowerSupply;
import spring.repository.PeCetRepository;
import spring.repository.PowerSupplyRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeCetService {

    private final PeCetRepository repository;
    public void delete(){repository.deleteAll();}

    public void save(final PeCet peCet, int id) {
        repository.save(peCet);
        peCet.setCustomerID(id);
    }

    public List<PeCet> getAll() {

        return repository.findAll().stream().collect(Collectors.toList());
    }
}
