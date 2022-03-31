package br.edu.cesmac.progv.repository;


import br.edu.cesmac.progv.entity.Cliente;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente, Long> {

    List<Cliente> findAll();

    Cliente save(Cliente produto);

    Cliente findById(Long id);

    void deleteById(Long id);
}
