package br.edu.cesmac.progv.service;

import br.edu.cesmac.progv.entity.Cliente;
import br.edu.cesmac.progv.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        this.validarSeOhNomeFoiInformado(cliente);
        return this.clienteRepository.save(cliente);
    }

    public Cliente consultarCliente(Long id) {
        return this.clienteRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        this.clienteRepository.deleteById(id);
    }

    public List<Cliente> listarClientes() {
        return this.clienteRepository.findAll();
    }

    private void validarSeOhNomeFoiInformado(Cliente cliente) {
        if (isEmpty(cliente.getNome())) {
            throw new RuntimeException("Obrigatório informar o nome!");
        }
    }

}
