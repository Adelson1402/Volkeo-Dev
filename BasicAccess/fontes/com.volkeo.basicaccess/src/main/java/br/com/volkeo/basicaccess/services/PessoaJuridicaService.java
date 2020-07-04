package br.com.volkeo.basicaccess.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.PessoaJuridicaEntity;
import br.com.volkeo.basicaccess.dao.repositories.PessoaJuridicaRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaRepository repo;

	public PessoaJuridicaEntity findById(Long id) {
		Optional<PessoaJuridicaEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa Juridica não encontrado"));
	}
	
	
	
}
