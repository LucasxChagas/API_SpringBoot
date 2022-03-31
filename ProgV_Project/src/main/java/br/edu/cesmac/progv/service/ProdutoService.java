package br.edu.cesmac.progv.service;

import br.edu.cesmac.progv.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.progv.repository.ProdutoRepository;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        this.validarSeOhNomeFoiInformado(produto);
        return this.produtoRepository.save(produto);
    }

    @Override
    public Produto consultarProduto(Long id) {
        return this.produtoRepository.findById(id);
    }

    public void deletar(Long id) {
        this.produtoRepository.deleteById(id);
    }

    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }

    private void validarSeOhNomeFoiInformado(Produto produto) {
        if (isEmpty(produto.getNome())) {
            throw new RuntimeException("Obrigatório informar o nome!");
        }
    }

}
