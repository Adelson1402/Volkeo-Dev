package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.TabTipoEnderecoEntity;
import br.com.volkeo.basicaccess.dao.repositories.TabTipoEnderecoRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;
import br.com.volkeo.basicaccess.to.TipoEnderecoTO;

@Service
public class TabTipoEnderecoService {

	@Autowired
	private TabTipoEnderecoRepository repo;

	public TabTipoEnderecoEntity findById(Long id) {
		Optional<TabTipoEnderecoEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Tipo de Endereço não encontrado"));
	}
	
	
	public List<TabTipoEnderecoEntity> findAll(){
	  return repo.findAll();	
	}
	
	public TabTipoEnderecoEntity add(TipoEnderecoTO to) {
	  TabTipoEnderecoEntity tipo = new TabTipoEnderecoEntity();
	  tipo.setDescricao(to.getDescricao());
	  repo.save(tipo);
	  return tipo;
	}
	
	public String delete(Long id) {
	  repo.deleteById(id);
	  return "OK";
	}
	
	public TabTipoEnderecoEntity update( TipoEnderecoTO to ) {
	  TabTipoEnderecoEntity tp = new TabTipoEnderecoEntity();
	  tp.setDescricao(to.getDescricao());
	  tp.setId(to.getId());
	  repo.save(tp);
	  return tp;
	}
	
	
}
