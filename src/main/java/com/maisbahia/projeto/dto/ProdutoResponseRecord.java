package com.maisbahia.projeto.dto;

//import com.maisbahia.projeto.model.enums.CategoriaProdutoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProdutoResponseRecord
(
    UUID idProduto,
    String nomeProduto,
//    CategoriaProdutoEnum categoria,
    Integer quantidade,
    String lote,
    LocalDate dataValidade,
    LocalDate dataFabricacao,
    String fabricante,
    LocalDateTime dataCadastro
) {}