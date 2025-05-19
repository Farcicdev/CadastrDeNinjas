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

    public MissoesModel listMissoesId(Long id){
        Optional<MissoesModel> missoesModel = modelMissoes.findById(id);
        return missoesModel.orElse(null);
    }

    public MissoesModel newMissao(MissoesModel missao){
        return modelMissoes.save(missao);
    }
}
