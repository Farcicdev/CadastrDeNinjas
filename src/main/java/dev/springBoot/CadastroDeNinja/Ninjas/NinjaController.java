package dev.springBoot.CadastroDeNinja.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/teste")//tenque ser minusculo
    public String boasVindas(){
        return ("Hello world");
    }

    //add ninja (create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "ninja criado";
    }

    //Mostrar ninja (READ)
    @GetMapping("/all")
    public String mostrarNinja(){
        return "Ninjas";
    }
    //mostrar inija por id
    @GetMapping("/allId")
    public String mostrarNinjaId(){
        return "NInja por id";
    }
    @PutMapping("alterarNinja")
    public String alterarNinjaPorId(){
        return "alterar NInja";
    }

    @DeleteMapping("/deeleporId")
    public String deletarNinjaPorId(){
        return "ninja deletado";
    }
}
