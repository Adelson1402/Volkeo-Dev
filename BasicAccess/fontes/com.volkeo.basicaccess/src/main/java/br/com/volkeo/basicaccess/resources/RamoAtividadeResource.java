package br.com.volkeo.basicaccess.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volkeo.basicaccess.dao.entities.RamoAtividadeEntity;
import br.com.volkeo.basicaccess.services.RamoAtividadeService;

@RestController
@RequestMapping(value = "/ramoAtividade")
public class RamoAtividadeResource {

	@Autowired
	private RamoAtividadeService service;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
		RamoAtividadeEntity obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/findAll")
	public ResponseEntity<?> findAll() {
		List<RamoAtividadeEntity> lst = service.findAllOrderBy("dsRamo");
		return ResponseEntity.ok().body(lst);
	}

}
