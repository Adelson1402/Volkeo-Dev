package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.TabTipoDocumentoEntity;
import br.com.volkeo.basicaccess.dao.repositories.TabTipoDocumentoRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;
import br.com.volkeo.basicaccess.to.TipoDocumentoTO;


@Service
public class TabTipoDocumentoService {

	@Autowired
	private TabTipoDocumentoRepository repo;

	public TabTipoDocumentoEntity findById(Long id) {
		Optional<TabTipoDocumentoEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Tipo de Endereço não encontrado"));
	}

	public List<TabTipoDocumentoEntity> findAll() {
		return repo.findAll();
	}

	public TabTipoDocumentoEntity add(TipoDocumentoTO to) {
		TabTipoDocumentoEntity tipo = new TabTipoDocumentoEntity();
		tipo.setCdTipoDocumento(to.getCdTipoDocumento());
		tipo.setDsTipoDocumento(to.getDsTipoDocumento());
		tipo.setFlPessoa(to.getFlPessoa());
		tipo.setMaskTipoDocumento(to.getMaskTipoDocumento());
		repo.save(tipo);
		return tipo;
	}

	public String delete(Long id) {
		repo.deleteById(id);
		return "OK";
	}

	public TabTipoDocumentoEntity update(TipoDocumentoTO to) {
		TabTipoDocumentoEntity tipo = new TabTipoDocumentoEntity();
		tipo.setCdTipoDocumento(to.getCdTipoDocumento());
		tipo.setDsTipoDocumento(to.getDsTipoDocumento());
		tipo.setFlPessoa(to.getFlPessoa());
		tipo.setMaskTipoDocumento(to.getMaskTipoDocumento());
		tipo.setId(to.getId());
		repo.save(tipo);
		return tipo;
	}

}
