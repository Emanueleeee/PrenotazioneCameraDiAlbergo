
package angular.spring.ngspring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "servizio")
public class Servizio implements Serializable
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="descrizione")
    private String descrizione;
   @ManyToMany(fetch=FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },mappedBy="listaServizi")
    private List<Prenotazione> listaPrenotazioni= new ArrayList<>();
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Servizio other = (Servizio) obj;
        return Objects.equals(this.id, other.id);
    }

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

    @Override
    public String toString()
    {
        return "Servizio{" + "descrizione=" + descrizione + '}';
    }


//    public List<Prenotazione> getListaPrenotazioni()
//    {
//        return listaPrenotazioni;
//    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni)
    {
        this.listaPrenotazioni = listaPrenotazioni;
    }

    

    
    
}