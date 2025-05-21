package dev.springBoot.CadastroDeNinja.Missoes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MissoesService {

    private MissoesRepository modelMissoes;


    public MissoesService(MissoesRepository modelMissoes) {
        this.modelMissoes = modelMissoes;
    }

    public List<MissoesModel> mostrarMissoes(){
        return modelMissoes.findAll();
    }

    public MissoesModel newMissao(MissoesModel missao){
        return modelMissoes.save(missao);
    }

    public void deleteMissoesId(Long id){
        modelMissoes.deleteById(id);
    }

    public MissoesModel alterarMissao(Long id, MissoesModel missoesModel){
        if(modelMissoes.existsById(id)){
            missoesModel.setId(id);
            return modelMissoes.save(missoesModel);
        }else{
            return null;
        }
    }

}
