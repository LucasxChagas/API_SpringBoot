package br.edu.cesmac.progv.resource;

import br.edu.cesmac.progv.entity.Produto;
import br.edu.cesmac.progv.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return this.produtoService.cadastrar(produto);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public Produto consultarProduto(@PathVariable("id") Long id) {
        return this.produtoService.consultarProduto(id);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        this.produtoService.deletar(id);
        return String.format("Produto com id (%s) foi apagado com sucesso!", id.toString());
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> listarProdutos() {
        return this.produtoService.listarProdutos();
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public Produto alterar(@RequestBody Produto produto) {
        this.produtoService.cadastrar(produto);
        return produto;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public List<Produto> cadastrar(@RequestBody List<Produto> listaDeProdutos) {
        List<Produto> listaDeProdutosSalvos = new ArrayList<>();
        for (Produto objProduto : listaDeProdutos) {
            Produto produtoCadastrado = this.produtoService.cadastrar(objProduto);
            listaDeProdutosSalvos.add(produtoCadastrado);
        }
        return listaDeProdutosSalvos;
    }

}