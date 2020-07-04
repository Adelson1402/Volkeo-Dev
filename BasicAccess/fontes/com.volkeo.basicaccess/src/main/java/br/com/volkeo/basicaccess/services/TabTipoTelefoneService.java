package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.TabTipoTelefoneEntity;
import br.com.volkeo.basicaccess.dao.repositories.TabTipoTelefoneRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;
import br.com.volkeo.basicaccess.to.TabTipoTelefoneTO;

@Service
public class TabTipoTelefoneService {

	@Autowired
	private TabTipoTelefoneRepository repo;

	public TabTipoTelefoneEntity findById(Long id) {
		Optional<TabTipoTelefoneEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Tipo de Telefone não encontrado"));
	}

	public List<TabTipoTelefoneEntity> findAll() {
		return repo.findAll();
	}

	public TabTipoTelefoneEntity add(TabTipoTelefoneTO to) {
		TabTipoTelefoneEntity tipo = new TabTipoTelefoneEntity();
		tipo.setDsTipo(to.getDsTipo());
		tipo.setDsMask(to.getDsMask());
		repo.save(tipo);
		return tipo;
	}

	public String delete(Long id) {
		repo.deleteById(id);
		return "OK";
	}

	public TabTipoTelefoneEntity update(TabTipoTelefoneTO to) {
		TabTipoTelefoneEntity tp = new TabTipoTelefoneEntity();
		tp.setDsTipo(to.getDsTipo());
		tp.setDsMask(to.getDsMask());
		tp.setId(to.getId());
		repo.save(tp);
		return tp;
	}

}
