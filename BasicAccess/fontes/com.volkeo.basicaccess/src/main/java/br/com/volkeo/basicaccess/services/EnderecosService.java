package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.TabEnderecoEntity;
import br.com.volkeo.basicaccess.dao.repositories.EnderecosRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class EnderecosService {

	@Autowired
	private EnderecosRepository repo;

	public TabEnderecoEntity findById(Long id) {
		Optional<TabEnderecoEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Endereco não encontrado"));
	}

	public List<TabEnderecoEntity> findByPerson(Long idPessoa) {
		return repo.findByPerson(idPessoa);
	}

	
	public void salveAllDocuments( List<TabEnderecoEntity> lstDocuments) {
	  repo.saveAll(lstDocuments);	
	}
	
	public void saveDocument(TabEnderecoEntity document) {
	  repo.save(document);	
	}
	
	public void deleteDocument(TabEnderecoEntity document) {
	  repo.deleteById(document.getId());	
	}

}
