package br.com.volkeo.basicaccess.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.PessoaFisicaEntity;
import br.com.volkeo.basicaccess.dao.repositories.PessoaFisicaRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository repo;

	public PessoaFisicaEntity findById(Long id) {
		Optional<PessoaFisicaEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa Física não encontrado"));
	}
	
	
}
