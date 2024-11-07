package com.maisbahia.projeto.controller;

import com.maisbahia.projeto.dto.ProdutoRequestRecord;
import com.maisbahia.projeto.dto.ProdutoResponseRecord;
import com.maisbahia.projeto.service.ProdutoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController
{
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseRecord> criarProduto(@RequestBody ProdutoRequestRecord request)
    {
        ProdutoResponseRecord response = produtoService.criarProduto(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseRecord>> listarProdutos()
    {
        List<ProdutoResponseRecord> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseRecord> buscarProdutoPorId (@PathVariable UUID id)
    {
        ProdutoResponseRecord response = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseRecord> atualizarProduto (@PathVariable UUID id, @RequestBody ProdutoRequestRecord request)
    {
        ProdutoResponseRecord response = produtoService.atualizarProduto(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto (@PathVariable UUID id)
    {
        produtoService.exluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
