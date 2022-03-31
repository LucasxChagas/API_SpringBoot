package br.edu.cesmac.progv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String anoNasc;

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getAnoNasc() { return anoNasc; }

    public void setAnoNasc(String anoNasc) { this.anoNasc = anoNasc; }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
