package com.maisbahia.projeto.model;

//import com.maisbahia.projeto.model.enums.CategoriaProdutoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;

//    @Enumerated(EnumType.STRING)
//    private CategoriaProdutoEnum categoria;

    private Integer quantidade;
    private String lote;
    private LocalDate dataValidade;
    private LocalDate dataFabricacao;
    private String fabricante;
    private String nomeProduto;
    private LocalDateTime dataCadastro;

}
