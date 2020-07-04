package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.EmailsEntity;
import br.com.volkeo.basicaccess.dao.repositories.EmailsRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class EmailsService {

	@Autowired
	private EmailsRepository repo;

	public EmailsEntity findById(Long id) {
		Optional<EmailsEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Email não encontrado"));
	}

	public List<EmailsEntity> findByPerson(Long idPessoa) {
		return repo.findByPerson(idPessoa);
	}

	public List<EmailsEntity> findByNumber(String nrDocumento) {
		return repo.findByNumber(nrDocumento);
	}

	public void salveAllDocuments(List<EmailsEntity> lstEmails) {
		repo.saveAll(lstEmails);
	}

	public void saveDocument(EmailsEntity email) {
		repo.save(email);
	}

	public void deleteDocument(EmailsEntity email) {
		repo.deleteById(email.getId());
	}

}
