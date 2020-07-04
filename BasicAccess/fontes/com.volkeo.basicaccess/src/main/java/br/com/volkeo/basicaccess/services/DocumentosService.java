package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.DocumentosEntity;
import br.com.volkeo.basicaccess.dao.repositories.DocumentosRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;

@Service
public class DocumentosService {

	@Autowired
	private DocumentosRepository repo;

	public DocumentosEntity findById(Long id) {
		Optional<DocumentosEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado"));
	}

	public List<DocumentosEntity> findByPerson(Long idPessoa) {
		return repo.findByPerson(idPessoa);
	}

	public List<DocumentosEntity> findByNumber(String nrDocumento) {
		return repo.findByNumber(nrDocumento);
	}

	public List<DocumentosEntity> findByNumberTypeDoc(String nrDocumento, String tipoDocumento) {
		return repo.findByNumberTypeDoc(nrDocumento, tipoDocumento);
	}
	
	
	public void salveAllDocuments( List<DocumentosEntity> lstDocuments) {
	  repo.saveAll(lstDocuments);	
	}
	
	public void saveDocument(DocumentosEntity document) {
	  repo.save(document);	
	}
	
	public void deleteDocument(DocumentosEntity document) {
	  repo.deleteById(document.getId());	
	}

}
