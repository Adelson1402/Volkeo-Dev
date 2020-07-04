package br.com.volkeo.basicaccess.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volkeo.basicaccess.dao.entities.TabTipoEnderecoEntity;
import br.com.volkeo.basicaccess.services.TabTipoEnderecoService;
import br.com.volkeo.basicaccess.to.TipoEnderecoTO;

@RestController
@RequestMapping(value = "/tipoEndereco")
public class TipoEnderecoResource {

	@Autowired
	private TabTipoEnderecoService service;
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
		TabTipoEnderecoEntity obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/findAll")
	public ResponseEntity<?> findAll(){
	  List<TabTipoEnderecoEntity> lst = service.findAll();
	  return ResponseEntity.ok().body(lst);
	}
	
	@RequestMapping(value="/insert" ,  method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody TipoEnderecoTO to ){
	  return ResponseEntity.ok().body(service.add(to));
	}
	
	@RequestMapping(value="/delete" ,  method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id ){
	  return ResponseEntity.ok().body(service.delete(id));
	}
	
	@RequestMapping(value="/update" ,  method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody TipoEnderecoTO to ){
	  return ResponseEntity.ok().body(service.update(to));
	}
	

}
