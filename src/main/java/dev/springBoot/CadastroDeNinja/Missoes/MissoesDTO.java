package dev.springBoot.CadastroDeNinja.Missoes;

import dev.springBoot.CadastroDeNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissoesDTO {

    private Long id;
    private String nomeMissao;
    private String dificuldade;
    private List<NinjaModel> ninjas;


}
