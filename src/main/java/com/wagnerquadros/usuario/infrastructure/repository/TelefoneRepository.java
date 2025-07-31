package com.wagnerquadros.usuario.infrastructure.repository;

import com.wagnerquadros.Curso_Javanauta.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
