package angular.spring.ngspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Prenotazione")
public class Prenotazione implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataInizio")
    private LocalDate dataInizio;
    @Column(name = "dataFine")
    private LocalDate dataFine;
    @ManyToOne
    @JoinColumn(name = "stanza_id")
    private Stanza stanza;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToMany(fetch = FetchType.LAZY, //qui definiusco la join table
            cascade = { //quindi per salvare la relazione
                CascadeType.PERSIST, //salveró la prenotazione e spring salvera entrambe
                CascadeType.MERGE
            })
    @JoinTable(
            name = "PrenotazioniOspite",
            joinColumns = @JoinColumn(name = "idPrenotazione"),
            inverseJoinColumns = @JoinColumn(name = "idOspite"))

    private List<Ospite> listaOspiti = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY, //qui definiusco la join table
            cascade = { //quindi per salvare la relazione
                CascadeType.PERSIST, //salveró la prenotazione e spring salvera entrambe
                CascadeType.MERGE
            })
    @JoinTable(
            name = "PrenotazioniServizio",
            joinColumns = @JoinColumn(name = "idPrenotazione"),
            inverseJoinColumns = @JoinColumn(name = "idServizio"))
    private List<Servizio> listaServizi = new ArrayList<>();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Prenotazione other = (Prenotazione) obj;
        return Objects.equals(this.id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    //GEt e set reinseriti, tolto il json funziona perchè i get e set vanno messi soltanto da chi richiama le altre classi
    public List<Ospite> getListaOspiti() {
        return listaOspiti;
    }
    public void setListaOspiti(List<Ospite> listaOspiti) {
        this.listaOspiti = listaOspiti;
    }

    public List<Servizio> getListaServizi() {
       return listaServizi;
   }

    public void setListaServizi(List<Servizio> listaServizi) {
        this.listaServizi = listaServizi;
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

}
