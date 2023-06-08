package br.com.projetoSpring.crudSpring.ModelFilme;

import br.com.projetoSpring.crudSpring.Controller.DadosAlteraFilme;
import groovy.transform.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer duracao;
    private Integer ano;
    private String genero;

    public Filme(DadosFilmes dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

    public Filme(){}

    @Override
    public String toString() {
        return "Filme [nome=" + nome + ", duracao=" + duracao + ", ano=" + ano + ", genero=" + genero + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;

    }

    public Long getId() {
        return id;
    }

    public void atualizadados(DadosAlteraFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

}
