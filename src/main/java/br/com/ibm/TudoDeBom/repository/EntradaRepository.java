package br.com.ibm.TudoDeBom.repository;

import br.com.ibm.TudoDeBom.entities.EntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<EntradaEntity, Long> {
}
