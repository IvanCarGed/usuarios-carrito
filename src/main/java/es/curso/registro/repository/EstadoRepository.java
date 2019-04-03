package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
