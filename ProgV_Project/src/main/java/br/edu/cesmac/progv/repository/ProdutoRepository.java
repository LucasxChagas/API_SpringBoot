package br.edu.cesmac.progv.repository;


import br.edu.cesmac.progv.entity.Produto;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProdutoRepository extends Repository<Produto, Long> {

    List<Produto> findAll();

    Produto save(Produto produto);

    Produto findById(Long id);

    void deleteById(Long id);
}
