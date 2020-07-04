package br.com.volkeo.basicaccess.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.volkeo.basicaccess.dao.entities.EmailsEntity;

@Repository
public interface EmailsRepository extends JpaRepository<EmailsEntity, Long> {

	@Query("select u from EmailsEntity u where u.pessoa.id = :idPessoa ")
	public List<EmailsEntity> findByPerson(@Param("idPessoa") Long idPessoa);

	@Query("select u from EmailsEntity u where u.dsEmail = :email ")
	public List<EmailsEntity> findByNumber(@Param("email") String email);

}
