package com.gabriel.pocMongoDB.service;

import com.gabriel.pocMongoDB.model.FuncionarioEntity;

import java.util.List;

public interface FuncionarioService {

    public List<FuncionarioEntity> obterTodos();

    public FuncionarioEntity obterPorCodigo(String codigo);

    public FuncionarioEntity criar(FuncionarioEntity funcionarioEntity);

    public List<FuncionarioEntity> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate);
}
