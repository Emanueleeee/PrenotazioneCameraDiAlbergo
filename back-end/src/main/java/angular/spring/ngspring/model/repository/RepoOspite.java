/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.repository;

import angular.spring.ngspring.model.Ospite;
import angular.spring.ngspring.model.Prenotazione;
import angular.spring.ngspring.model.Servizio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hutti
 */
@Repository
public interface RepoOspite extends JpaRepository<Ospite,Long> {

    @Query(value="select o.id,o.nome,o.cognome,o.documento,o.indirizzo from Ospite o , prenotazioni_ospite po "
            + "where o.id = po.id_ospite and po.id_prenotazione = :id",
            nativeQuery =true)
    public List<Ospite> findAllByPrenotazione(@Param("id") Long id);
    public Ospite findByDocumento(String Documento);
    
}
