
package angular.spring.ngspring.model.repository;

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
public interface RepoServizio extends JpaRepository<Servizio,Long> {

    @Query(value="select s.id,s.descrizione from Servizio s , prenotazioni_servizio ps "
            + "where s.id = ps.id_servizio And ps.id_prenotazione = :id", nativeQuery=true)
    public List<Servizio> findAllByPrenotazione(@Param("id") Long id);
    
}
