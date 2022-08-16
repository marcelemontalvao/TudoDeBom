package br.com.ibm.TudoDeBom.repository;

import br.com.ibm.TudoDeBom.entities.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, Long> {
}
