/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.repository;

import angular.spring.ngspring.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hutti
 */
@Repository
public interface RepoUtente extends JpaRepository<Utente,Long>  {
    
    public Utente findByUsername(String Username);
    public Utente findByUsernameAndPassword (String username, String password);
}
