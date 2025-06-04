package dev.springBoot.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaDTO;


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    @Autowired
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaDTO) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaDTO = ninjaDTO;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return ninja.stream()
                .map(ninjaDTO::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listNinjaId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);//optopnal usa caso a informacao existir ou nao, no caso o ninja pode ou nao existir no casdastro
        return ninjaModel.map(ninjaDTO::map).orElse(null);
    }

    public NinjaDTO newNinja(NinjaDTO ninjaDto){
        NinjaModel ninja = ninjaDTO.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaDTO.map(ninja);

    }
    //deletar ninja tem que ser um metado void
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }


    //alterar Ninja
    public NinjaDTO alterarNinja(Long id, NinjaDTO ninja){
        Optional<NinjaModel> ninjaexistente = ninjaRepository.findById(id);
        if(ninjaexistente.isPresent()){
            NinjaModel ninjaatualizado = ninjaDTO.map(ninja);
            ninjaatualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaatualizado);
            return ninjaDTO.map(ninjaSalvo);
        }else{
            return null;
        }


        /*if (ninjaRepository.existsById(id)){
            ninjaatualizado.setId(id);//sobrescrever o iD
            return ninjaRepository.save(ninjaatualizado);
        }else {
            return null;
        }*/
    }
}
