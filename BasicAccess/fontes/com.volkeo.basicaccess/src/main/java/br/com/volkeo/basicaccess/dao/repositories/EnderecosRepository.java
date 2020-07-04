package br.com.volkeo.basicaccess.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.volkeo.basicaccess.dao.entities.TabEnderecoEntity;

@Repository
public interface EnderecosRepository extends JpaRepository<TabEnderecoEntity,Long>{

	@Query("select u from TabEnderecoEntity u where u.pessoa.id = :idPessoa ")
	public List<TabEnderecoEntity> findByPerson(@Param("idPessoa") Long idPessoa);

	
	
}
