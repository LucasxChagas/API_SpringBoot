package br.edu.cesmac.progv.service;

import br.edu.cesmac.progv.entity.Produto;

public interface IProdutoService {

    Produto cadastrar(Produto produto);

    Produto consultarProduto(Long id);

}
