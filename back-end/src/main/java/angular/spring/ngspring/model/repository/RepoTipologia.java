/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.repository;

import angular.spring.ngspring.model.Tipologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hutti
 */
@Repository
public interface RepoTipologia extends JpaRepository<Tipologia,Long> {
    @Query(value="select t.id,t.capienza,t.descrizione from Tipologia t, stanza s , prenotazione p "
            + " where p.stanza_id=s.id And t.id = s.tipologia_id And p.id = :id ", nativeQuery=true)
    public Tipologia findByTipologiaXStanza(@Param("id") Long id);
}
