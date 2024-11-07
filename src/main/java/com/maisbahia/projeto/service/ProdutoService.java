package com.maisbahia.projeto.service;

import com.maisbahia.projeto.dto.ProdutoRequestRecord;
import com.maisbahia.projeto.dto.ProdutoResponseRecord;
import com.maisbahia.projeto.model.Produto;
import com.maisbahia.projeto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService
{

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository)
    {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponseRecord criarProduto(ProdutoRequestRecord request)
    {
        Produto produto = new Produto(
                null,
//                request.categoria(),
                request.quantidade(),
                request.lote(),
                request.dataValidade(),
                request.dataFabricacao(),
                request.fabricante(),
                request.nomeProduto(),
                LocalDateTime.now()
        );
        produto = produtoRepository.save(produto);
        return mapToResponseRecord(produto);
    }

    public List<ProdutoResponseRecord> listarProdutos()
    {
        return produtoRepository.findAll().stream().map(this::mapToResponseRecord).collect(Collectors.toList());
    }

    public ProdutoResponseRecord buscarProdutoPorId(UUID id)
    {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return mapToResponseRecord(produto);
    }

    public ProdutoResponseRecord atualizarProduto(UUID id, ProdutoRequestRecord request)
    {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNomeProduto(request.nomeProduto());
//        produto.setCategoria(request.categoria());
        produto.setQuantidade(request.quantidade());
        produto.setLote(request.lote());
        produto.setDataValidade(request.dataValidade());
        produto.setDataFabricacao(request.dataFabricacao());
        produto.setFabricante(request.fabricante());

        produto = produtoRepository.save(produto);
        return mapToResponseRecord(produto);
    }

    public void exluirProduto(UUID id)
    {
        if (!produtoRepository.existsById(id))
        {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public ProdutoResponseRecord mapToResponseRecord(Produto produto)
    {
        return new ProdutoResponseRecord(
                produto.getIdProduto(),
                produto.getNomeProduto(),
//                produto.getCategoria(),
                produto.getQuantidade(),
                produto.getLote(),
                produto.getDataValidade(),
                produto.getDataFabricacao(),
                produto.getFabricante(),
                produto.getDataCadastro()
        );
    }
}
