package dev.springBoot.CadastroDeNinja.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/teste")//tenque ser minusculo
    public String boasVindas(){
        return ("Hello world");
    }
}
