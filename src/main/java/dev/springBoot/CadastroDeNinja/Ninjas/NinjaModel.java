package dev.springBoot.CadastroDeNinja.Ninjas;

import dev.springBoot.CadastroDeNinja.Missoes.NinjaMissoes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//tranforma a classe em banco de dados
//JPA java percistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
