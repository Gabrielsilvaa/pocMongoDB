package com.gabriel.pocMongoDB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class FuncionarioEntity {

    @Id
    private String codigo;
    private String nome;
    private Integer idade;
    private BigDecimal salario;

    @DBRef
    private FuncionarioEntity chef;

}
