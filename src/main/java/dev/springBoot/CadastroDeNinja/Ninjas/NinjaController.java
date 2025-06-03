package dev.springBoot.CadastroDeNinja.Ninjas;


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

    @GetMapping("/teste")//tenque ser minusculo
    public String boasVindas() {
        return ("Hello world");
    }

    //add ninja (create)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaModel) {
        return ninjalist.newNinja(ninjaModel);
    }

    //Mostrar ninja (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarNinja() {
        return ninjalist.listarNinjas();
    }

    //mostrar inija por id
    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinjaId(@PathVariable Long id) {
        return ninjalist.listNinjaId(id);
    }

    @PutMapping("/alterarNinja/{id}")
    public NinjaDTO alteraNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaBody) {
        return ninjalist.alterarNinja(id, ninjaBody);
    }

    @DeleteMapping("/deletepor/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjalist.deletarNinjaId(id);
    }
}