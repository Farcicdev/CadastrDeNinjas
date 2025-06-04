package dev.springBoot.CadastroDeNinja.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    public NinjaService ninjalist;

    public NinjaController(NinjaService ninjalist) {
        this.ninjalist = ninjalist;
    }

    /*@GetMapping("/teste")//tenque ser minusculo
    public String boasVindas() {
        return ("Hello world");
    }*/

    //add ninja (create)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninjaDTO = ninjalist.newNinja(ninjaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaDTO.getNome() + " criado com sucesso");
    }

    //Mostrar ninja (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarNinja() {
        List<NinjaDTO> ninjaDTOS = ninjalist.listarNinjas();
        return ResponseEntity.ok(ninjaDTOS);
    }

    //mostrar inija por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjaId(@PathVariable Long id) {
        NinjaDTO ninjas = ninjalist.listNinjaId(id);
        if(ninjas != null){
            return ResponseEntity.ok(ninjas);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja nao existe no Banco de dados");
        }

    }

    @PutMapping("/alterarNinja/{id}")
    public ResponseEntity<?> alteraNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaBody) {
        NinjaDTO ninjaalterado = ninjalist.alterarNinja(id, ninjaBody);
        if(ninjaalterado != null){
            return ResponseEntity.ok(ninjaalterado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja nao existe");
        }
    }

    @DeleteMapping("/deletepor/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        //ninjalist.deletarNinjaId(id);
        if(ninjalist.listNinjaId(id) != null){
            ninjalist.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com id "+ id +" deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com id "+id+" nao foi encontrado.");
    }
}