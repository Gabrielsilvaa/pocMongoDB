package com.gabriel.pocMongoDB.controller;

import com.gabriel.pocMongoDB.model.FuncionarioEntity;
import com.gabriel.pocMongoDB.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioEntity> obterTodos(){
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public FuncionarioEntity obterPorCodigo(@PathVariable String codigo){
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public FuncionarioEntity criar(@RequestBody FuncionarioEntity funcionario){
        return  this.funcionarioService.criar(funcionario);
    }

    @GetMapping("/rangeIdade")
    public List<FuncionarioEntity> obterPorRangeDeIdade(@RequestParam("de") Integer de,
                                                  @RequestParam("ate") Integer ate){
        return this.funcionarioService.obterFuncionariosPorRangeDeIdade(de,ate);
    }
}
