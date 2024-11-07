package com.maisbahia.projeto.dto;

//import com.maisbahia.projeto.model.enums.CategoriaProdutoEnum;
import java.time.LocalDate;

public record ProdutoRequestRecord
(
    String nomeProduto,
//    CategoriaProdutoEnum categoria,
    Integer quantidade,
    String lote,
    LocalDate dataValidade,
    LocalDate dataFabricacao,
    String fabricante
) {}
