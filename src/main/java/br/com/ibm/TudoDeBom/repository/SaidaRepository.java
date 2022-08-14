package br.com.ibm.TudoDeBom.repository;

import br.com.ibm.TudoDeBom.entities.SaidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaRepository extends JpaRepository<SaidaEntity, Long> {
}
