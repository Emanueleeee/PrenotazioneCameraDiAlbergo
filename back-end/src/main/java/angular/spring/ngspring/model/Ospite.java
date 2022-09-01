/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angular.spring.ngspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name="Ospite")
public class Ospite implements Serializable{
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true,name="Documento",nullable=false)
    
    private String documento;
    
    @Column(name="Nome",nullable=false)
    @NotNull
    private String nome;
    
    @Column(name="Cognome",nullable=false)
    @NotNull
    private String cognome;
    
    @Column(name="Indirizzo")
    private String indirizzo;
    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },mappedBy="listaOspiti")
    private List<Prenotazione> listaPrenotazioni= new ArrayList<>();

    //Getters and Setters
    //    public List<Prenotazione> getListaPrenotazioni()
    //    {
    //        return listaPrenotazioni;
    //    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni)
    {
        this.listaPrenotazioni = listaPrenotazioni;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Ospite other = (Ospite) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ospite{" + "documento=" + documento + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + '}';
    }
    
}
