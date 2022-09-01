package angular.spring.ngspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hutti
 */
@Entity
@Table(name="Stanza")
public class Stanza implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="numerostanza")
    private Integer numeroStanza;
    @OneToMany(cascade=CascadeType.ALL,
            fetch=FetchType.LAZY,
            mappedBy="stanza")
    
    private List<Prenotazione> listaPrenotazioni=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "tipologia_id")
    private Tipologia tipologia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroStanza() {
        return numeroStanza;
    }

    public void setNumeroStanza(Integer numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Stanza other = (Stanza) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stanza{" + "numeroStanza=" + numeroStanza + '}';
    }



    /*public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }*/

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }


    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }
    
    public Tipologia getTipologia() {
        return tipologia;
    }
    
    
    
}
