package com.gabriel.pocMongoDB.service.impl;

import com.gabriel.pocMongoDB.model.FuncionarioEntity;
import com.gabriel.pocMongoDB.repository.FuncionarioRepository;
import com.gabriel.pocMongoDB.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioEntity> obterTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioEntity obterPorCodigo(String codigo) {
        return this.funcionarioRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Funcionario nao existe"));
    }

    @Override
    public FuncionarioEntity criar(FuncionarioEntity funcionarioEntity) {
        var chef = this.funcionarioRepository.findById(funcionarioEntity.getChef().getCodigo()).orElseThrow(() -> new IllegalArgumentException("chefe inecistente."));

        funcionarioEntity.setChef(chef);

        return funcionarioRepository.save(funcionarioEntity);
    }

    @Override
    public List<FuncionarioEntity> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
        return this.funcionarioRepository.obterFuncionarioPorRangeDeIdade(de, ate);
    }
}
