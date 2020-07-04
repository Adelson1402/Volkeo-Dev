package br.com.volkeo.basicaccess;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class ConexaoTeste {

	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public String find(@PathVariable Long id) {
      //Categoria obj = service.buscar(id);
	  return "Teste";
	}
	
}
