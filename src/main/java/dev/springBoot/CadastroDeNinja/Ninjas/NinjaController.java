package dev.springBoot.CadastroDeNinja.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    public NinjaService ninjalist;

    public NinjaController(NinjaService ninjalist) {
        this.ninjalist = ninjalist;
    }

    @GetMapping("/teste")//tenque ser minusculo
    public String boasVindas(){
        return ("Hello world");
    }

    //add ninja (create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
        return ninjalist.newNinja(ninjaModel);
    }

    //Mostrar ninja (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarNinja(){
        return ninjalist.listarNinjas();
    }
    //mostrar inija por id
    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjaId(@PathVariable Long id){
        return ninjalist.listNinjaId(id);
    }
    @PutMapping("alterarNinja")
    public String alterarNinjaPorId(){
        return "alterar NInja";
    }

    @DeleteMapping("/deleteporId")
    public String deletarNinjaPorId(){
        return "ninja deletado";
    }
}
