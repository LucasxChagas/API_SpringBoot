package br.edu.cesmac.progv;

import br.edu.cesmac.progv.entity.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;

public class Teste {

    public static void main(String[] args) {

        Produto produto = new Produto();



        if (isEmpty(produto.getNome())) {
            System.out.println("É vazio!");
        }



        if (produto == null ||
                produto.getNome() == null ||
                produto.getNome().equals("")) {
            System.out.println("Obrigatório informar o nome do produto!");
        } else {
            System.out.println("Produto cadastrado com sucesso!");
        }


        List<String> nomesDosAlunos = new ArrayList<>();

        nomesDosAlunos.add("Pedro");
        nomesDosAlunos.add("Lucas");
        nomesDosAlunos.add("Maria");

        if (nomesDosAlunos.contains("Maria")) {
            System.out.println("Maria está na lista!");
        } else {
            System.out.println("Maria faltou!");
        }

        System.out.println("Maria está na posição: " + nomesDosAlunos.indexOf("Maria"));

        System.out.println("\n Lista de Nomes:");
        for (int i = 0; i < nomesDosAlunos.size(); i++) {
            System.out.println(nomesDosAlunos.get(i));
        }

        List<Produto> listaProdutos = new ArrayList<>();

        Produto p1 = new Produto();

        listaProdutos.add(p1);

        p1.setId(1L);
        p1.setNome("Roberth");

        System.out.println("Lista de Produtos: ");

        for (Produto p : listaProdutos) {
            System.out.println(p.getId());
            System.out.println(p.getNome());
        }

    }

}
