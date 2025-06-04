package dev.springBoot.CadastroDeNinja.Missoes;

import dev.springBoot.CadastroDeNinja.Ninjas.NinjaDTO;
import dev.springBoot.CadastroDeNinja.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;

    }
    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());
        return missoesDTO;
    }
}
