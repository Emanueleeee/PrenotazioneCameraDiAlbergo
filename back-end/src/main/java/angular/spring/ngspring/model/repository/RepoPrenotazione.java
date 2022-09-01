/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.repository;

import angular.spring.ngspring.model.Prenotazione;
import angular.spring.ngspring.model.Stanza;
import java.sql.Date;
import java.time.LocalDate;
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
public interface RepoPrenotazione extends JpaRepository<Prenotazione, Long>
{
    public List<Prenotazione> findAllByUtenteIdOrderByDataInizioDesc(Long id);
}
