/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package angular.spring.ngspring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hutti
 */
@Entity
@Table(name="Tipologia")
public class Tipologia implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="descrizione")
    private String descrizione;
    
    @Column(name="capienza")
    private Integer capienza;
    
    @OneToMany(cascade=CascadeType.ALL,
               fetch = FetchType.EAGER,
               mappedBy="tipologia")
    private List<Stanza> stanze = new ArrayList<>();
    

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public Integer getCapienza()
    {
        return capienza;
    }

    public void setCapienza(Integer capienza)
    {
        this.capienza = capienza;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Tipologia other = (Tipologia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString()
    {
        return "Tipologia{" + "descrizione=" + descrizione + ", capienza=" + capienza + '}';
    }

//    public List<Stanza> getStanze() {
//        return stanze;
//    }

//    public void setStanze(List<Stanza> stanze) {
//        this.stanze = stanze;
//    }


    
    
}
