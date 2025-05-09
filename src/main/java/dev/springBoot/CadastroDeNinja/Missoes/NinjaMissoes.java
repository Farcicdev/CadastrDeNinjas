package dev.springBoot.CadastroDeNinja.Missoes;

import dev.springBoot.CadastroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class NinjaMissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissao;

    private rankEnum dificuldade;

    //uma missao tera varios ninjas
    @OneToMany(mappedBy = "missoesNinja")
    private List<NinjaModel> ninjas;

}
