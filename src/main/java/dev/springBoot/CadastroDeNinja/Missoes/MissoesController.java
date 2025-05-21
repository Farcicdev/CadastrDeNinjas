package dev.springBoot.CadastroDeNinja.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

//LOCALHOST:8080/deletar/1
@RestController//controlar rota
@RequestMapping("/missao")//maear API
public class MissoesController {

    private MissoesService listmissoes;

    public MissoesController(MissoesService listmissoes) {
        this.listmissoes = listmissoes;
    }

    //Post -- Mandar uma requisisao para o usuario criar algo mandar a informacao
    @PostMapping("/criar")
    public MissoesModel criar(@RequestBody MissoesModel missoesModel ){
        return listmissoes.newMissao(missoesModel);
    }
    //GET -- Mandar uma requisisao para mostrar algo para o usuario
    @GetMapping("/missoes")
    public List<MissoesModel> mostrarMissoes(){
        return listmissoes.mostrarMissoes();        
    }

    @PutMapping("/alterar/{id}")//@Patchvariable quando precisar do id no url colocar essa annotation
    public MissoesModel alterarNinjas(@PathVariable Long id,@RequestBody MissoesModel missoesAtualizada){
        return listmissoes.alterarMissao(id,missoesAtualizada);
    }

    @DeleteMapping("/deleta/{id}")
    public void deletaMissao(@PathVariable Long id){
        listmissoes.deleteMissoesId(id);
    }
}
