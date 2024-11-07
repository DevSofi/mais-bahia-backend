package com.maisbahia.projeto.repository;

import com.maisbahia.projeto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {}
