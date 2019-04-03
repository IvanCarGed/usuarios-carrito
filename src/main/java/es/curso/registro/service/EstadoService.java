package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Estado;

public interface EstadoService {
	
	List<Estado> getAll();
	
	Estado findById(Integer i);
}
