/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.repository;

import angular.spring.ngspring.model.Stanza;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hutti
 */
@Repository
public interface RepoStanza extends JpaRepository<Stanza,Long> {

    public List<Stanza> findByTipologiaId(Long id);
    
}
