package dev.springBoot.CadastroDeNinja.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> criar(@RequestBody MissoesDTO missoesModel)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       {
        MissoesDTO missoes = listmissoes.newMissao(missoesModel);
        return ResponseEntity.ok().body(missoes.getNomeMissao()+" criado com sucesso");
    }
    //GET -- Mandar uma requisisao para mostrar algo para o usuario
    @GetMapping("/missoes")
    public List<MissoesDTO> mostrarMissoes(){
        return listmissoes.mostrarMissoes();        
    }

    @GetMapping("/missoes/{id}")
    public ResponseEntity<?> missoesId(@PathVariable Long id){
        MissoesDTO missoesDTO = listmissoes.mostrarmissoesId(id);
        if(missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao existe");
        }
    }

    @PutMapping("/alterar/{id}")//@Patchvariable quando precisar do id no url colocar essa annotation
    public ResponseEntity<String> alterarNinjas(@PathVariable Long id,@RequestBody MissoesDTO missoesAtualizada){
        MissoesDTO missoesDTO = listmissoes.alterarMissao(id,missoesAtualizada);
        if (missoesDTO != null){
            return ResponseEntity.ok("Ninja alterado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja nao encontrado");
        }
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletaMissao(@PathVariable Long id){
       if (listmissoes.mostrarmissoesId(id) != null){
           listmissoes.deleteMissoesId(id);
           return ResponseEntity.ok().body("Ninja deletado");
       }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado");
       }
    }
}
