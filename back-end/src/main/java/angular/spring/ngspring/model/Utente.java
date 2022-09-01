/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package angular.spring.ngspring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author hutti
 */
@Entity
@Table(name="utente")
public class Utente implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,name="username")
    private String username;
    @Column(name="password",nullable=false)
    private String password;
    @Column(name="gestore")
    private Boolean gestore;
    @Column(name="nome")
    private String nome;
    @Column(name="cognome")
    private String cognome;
    @Column (name="email")
    private String email;
    @OneToMany(cascade=CascadeType.ALL,
            fetch=FetchType.LAZY,
            mappedBy="utente")
    private List<Prenotazione> listaPrenotazioni=new ArrayList<>();
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGestore() {
        return gestore;
    }

    public void setGestore(Boolean gestore) {
        this.gestore = gestore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//   public List<Prenotazione> getListaPrenotazioni() {
//        return listaPrenotazioni;
//    }
//
    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }
    
}
