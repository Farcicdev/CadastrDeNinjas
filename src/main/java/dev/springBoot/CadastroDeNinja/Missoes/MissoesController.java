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

    @GetMapping("/missoes/{id}")
    public MissoesModel listId(@PathVariable Long id){
        return listmissoes.listMissoesId(id);
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "alterada a missao";
    }

    @DeleteMapping("/deleta")
    public String deletaMissao(){
        return "deletada a missao";
    }
}
