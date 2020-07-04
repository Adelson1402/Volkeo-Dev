package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.TelefonesEntity;
import br.com.volkeo.basicaccess.dao.repositories.TelefonesRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class TelefonesService {
	
	@Autowired
	private TelefonesRepository repo;
	
	public TelefonesEntity findById(Long id) {
		Optional<TelefonesEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Telefone não encontrado"));
	}

	public List<TelefonesEntity> findByPerson(Long idPessoa) {
		return repo.findByPerson(idPessoa);
	}

	public List<TelefonesEntity> findByNumber(String nrDocumento) {
		return repo.findByNumber(nrDocumento);
	}

	public void salveAllDocuments(List<TelefonesEntity> lstEmails) {
		repo.saveAll(lstEmails);
	}

	public void saveDocument(TelefonesEntity email) {
		repo.save(email);
	}

	public void deleteDocument(TelefonesEntity email) {
		repo.deleteById(email.getId());
	}

}
