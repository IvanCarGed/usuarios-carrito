package es.curso.registro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Estado;
import es.curso.registro.repository.EstadoRepository;
import es.curso.registro.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> getAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado findById(Integer id) {
		return estadoRepository.findById(id).get();
	}

}
