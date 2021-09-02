package com.gabriel.pocMongoDB.repository;

import com.gabriel.pocMongoDB.model.FuncionarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<FuncionarioEntity, String> {

    @Query("{ $and: [ { 'idade': { $gte: ?0 } }, { { 'idade': {$lte:?1 } } } ] }")
    public List<FuncionarioEntity> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);

    public List<FuncionarioEntity> findByNome(String nome);

}
