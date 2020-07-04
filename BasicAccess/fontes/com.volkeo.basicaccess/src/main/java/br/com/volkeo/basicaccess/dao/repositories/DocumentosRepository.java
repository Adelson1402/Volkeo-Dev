package br.com.volkeo.basicaccess.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.volkeo.basicaccess.dao.entities.DocumentosEntity;

@Repository
public interface DocumentosRepository extends JpaRepository<DocumentosEntity, Long> {

	@Query("select u from DocumentosEntity u where u.pessoa.id = :idPessoa ")
	public List<DocumentosEntity> findByPerson(@Param("idPessoa") Long idPessoa);

	@Query("select u from DocumentosEntity u where u.nrDocumento = :nrDocumento ")
	public List<DocumentosEntity> findByNumber(@Param("nrDocumento") String nrDocumento);

	@Query("select u from DocumentosEntity u where u.nrDocumento = :nrDocumento and u.idTpDoc.cdTipoDocumento = :cod ")
	public List<DocumentosEntity> findByNumberTypeDoc(@Param("nrDocumento") String nrDocumento,
			@Param("cod") String cod);

}
