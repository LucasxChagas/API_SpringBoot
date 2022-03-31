package br.edu.cesmac.progv.resource;

import br.edu.cesmac.progv.entity.Cliente;
import br.edu.cesmac.progv.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteResource {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return this.clienteService.cadastrarCliente(cliente);
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public Cliente consultarCliente(@PathVariable("id") Long id) {
        return this.clienteService.consultarCliente(id);
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    public String deletarCliente (@PathVariable("id") Long id) {
        this.clienteService.deletarCliente(id);
        return String.format("Cliente com id (%s) foi apagado com sucesso!", id.toString());
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<Cliente> listarClientes() {
        return this.clienteService.listarClientes();
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.PUT)
    public Cliente alterarCliente (@RequestBody Cliente cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return cliente;
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public List<Cliente> cadastrarCliente (@RequestBody List<Cliente> listaDeClientes) {
        List<Cliente> listaDeClientesSalvos = new ArrayList<>();
        for (Cliente objCliente : listaDeClientes) {
            Cliente clienteCadastrado = this.clienteService.cadastrarCliente(objCliente);
            listaDeClientesSalvos.add(clienteCadastrado);
        }
        return listaDeClientesSalvos;
    }

}