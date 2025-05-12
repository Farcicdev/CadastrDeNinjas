package dev.springBoot.CadastroDeNinja.Missoes;

import dev.springBoot.CadastroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissao;

    private rankEnum dificuldade;

    //uma missao tera varios ninjas
    @OneToMany(mappedBy = "missoesNinja")
    private List<NinjaModel> ninjas;



}
