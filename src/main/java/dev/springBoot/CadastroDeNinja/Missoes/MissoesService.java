package dev.springBoot.CadastroDeNinja.Missoes;

import dev.springBoot.CadastroDeNinja.Ninjas.NinjaDTO;
import dev.springBoot.CadastroDeNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class MissoesService {

    private MissoesMapper mapperMissoes;

    private MissoesRepository modelMissoes;

    public MissoesService(MissoesMapper mapperMissoes, MissoesRepository modelMissoes) {
        this.mapperMissoes = mapperMissoes;
        this.modelMissoes = modelMissoes;
    }

    public List<MissoesDTO> mostrarMissoes(){
        List<MissoesModel> ninja = modelMissoes.findAll();
        return ninja.stream()
                .map(missoesModel -> mapperMissoes.map(missoesModel))// = mapperMissoes::map
                .collect(Collectors.toList());
    }

    public MissoesDTO newMissao(MissoesDTO missaoDTO){
        MissoesModel missao = mapperMissoes.map(missaoDTO);
        missao = modelMissoes.save(missao);
        return mapperMissoes.map(missao);

    }

    public void deleteMissoesId(Long id){
        modelMissoes.deleteById(id);
    }

    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO) {

       Optional<MissoesModel> missoesExistente = modelMissoes.findById(id);
        if (missoesExistente.isPresent()) {
            MissoesModel missoesAtualizadas = mapperMissoes.map(missoesDTO);
            missoesAtualizadas.setId(id);
            MissoesModel ninjaSalvo = modelMissoes.save(missoesAtualizadas);
            return mapperMissoes.map(ninjaSalvo);
        } else {
            return null;
        }
    }
}
