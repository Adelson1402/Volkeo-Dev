package br.com.volkeo.basicaccess.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.volkeo.basicaccess.dao.entities.RamoAtividadeEntity;

@Repository
public interface RamoAtividadesRepository extends JpaRepository<RamoAtividadeEntity, Long> {

}
