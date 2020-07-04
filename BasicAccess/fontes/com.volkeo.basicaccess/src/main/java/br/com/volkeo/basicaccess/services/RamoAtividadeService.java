package br.com.volkeo.basicaccess.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.RamoAtividadeEntity;
import br.com.volkeo.basicaccess.dao.repositories.RamoAtividadesRepository;
import br.com.volkeo.basicaccess.services.exception.ObjectNotFoundException;


@Service
public class RamoAtividadeService {

	@Autowired
	private RamoAtividadesRepository repo;

	public RamoAtividadeEntity findById(Long id) {
		Optional<RamoAtividadeEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Ramo de Atividade não encontrado"));
	}

	public List<RamoAtividadeEntity> findAll() {
		return repo.findAll();
	}
	
	public List<RamoAtividadeEntity> findAllOrderBy(String ordem){
	  return repo.findAll(Sort.by(Sort.Direction.ASC, ordem));	
	}

	
}
