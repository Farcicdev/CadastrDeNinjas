package dev.springBoot.CadastroDeNinja.Ninjas;

import dev.springBoot.CadastroDeNinja.Missoes.NinjaMissoes;
import jakarta.persistence.*;

import java.util.List;

//tranforma a classe em banco de dados
//JPA java percistence API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    //@manyToOne varios ninjas terao uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")//Foreing key ou chave estrangeira
    private NinjaMissoes missoesNinja;


    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
