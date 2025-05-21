package dev.springBoot.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjaId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);//optopnal usa caso a informacao existir ou nao, no caso o ninja pode ou nao existir no casdastro
        return ninjaModel.orElse(null);
    }

    public NinjaModel newNinja (NinjaModel ninja){

        return ninjaRepository.save(ninja);

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
