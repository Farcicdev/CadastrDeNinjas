package dev.springBoot.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaDTO;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaDTO) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaDTO = ninjaDTO;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjaId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);//optopnal usa caso a informacao existir ou nao, no caso o ninja pode ou nao existir no casdastro
        return ninjaModel.orElse(null);
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
    public  NinjaModel alterarNinja(Long id, NinjaModel ninjaatualizado){
        if (ninjaRepository.existsById(id)){
            ninjaatualizado.setId(id);
            return ninjaRepository.save(ninjaatualizado);
        }else {
            return null;
        }
    }
}
