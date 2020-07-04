package br.com.volkeo.basicaccess.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.volkeo.basicaccess.dao.entities.TelefonesEntity;

@Repository
public interface TelefonesRepository extends JpaRepository<TelefonesEntity,Long>{

	@Query("select u from TelefonesEntity u where u.pessoa.id = :idPessoa ")
	public List<TelefonesEntity> findByPerson(@Param("idPessoa") Long idPessoa);

	@Query("select u from TelefonesEntity u where u.nrNumero = :nrNumero ")
	public List<TelefonesEntity> findByNumber(@Param("nrNumero") String nrNumero);

		
}
