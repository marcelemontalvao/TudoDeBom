package br.com.ibm.TudoDeBom.repository;

import br.com.ibm.TudoDeBom.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    
}