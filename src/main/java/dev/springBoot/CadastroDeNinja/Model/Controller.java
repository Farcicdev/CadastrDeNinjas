package dev.springBoot.CadastroDeNinja.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/teste")//tenque ser minusculo
    public String boasVindas(){
        return ("Hello world");
    }
}
