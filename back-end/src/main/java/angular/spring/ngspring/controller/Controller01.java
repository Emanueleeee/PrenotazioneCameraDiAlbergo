package angular.spring.ngspring.controller;

import angular.spring.ngspring.model.Ospite;
import angular.spring.ngspring.model.Prenotazione;
import angular.spring.ngspring.model.Servizio;
import angular.spring.ngspring.model.Stanza;
import angular.spring.ngspring.model.Tipologia;
import angular.spring.ngspring.model.Utente;
import angular.spring.ngspring.model.service.ServicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class Controller01
{

    @Autowired
    ServicesImpl servImpl;

    //METODI UTENTE
    @RequestMapping(value ={"/registrazione"})
    @ResponseBody
    public Boolean Registrazione(
            @RequestBody Utente utente)
    {
        return this.servImpl.registrazione(utente);
    }

    @RequestMapping(value ={"/login"})
    @ResponseBody
    public Utente Login(
            @RequestBody Utente utente)
    {

        return this.servImpl.accesso(utente);
    }

    //METODI TIPOLOGIA
    @RequestMapping(value ={"/listaTipologia"})
    @ResponseBody
    public List<Tipologia> listaTipologia()
    {
        return this.servImpl.listaTipologia();
    }
    @RequestMapping(value ={"/trovaTipologia"})
    @ResponseBody
    public Tipologia trovaTipologia(@RequestBody Long id)
    {
        return this.servImpl.trovaTipologia(id);
    }

    
    //METODI STANZE

    @RequestMapping(value ={"/listaStanze"})
    @ResponseBody
    public List<Stanza> listaStanzePerTipologia(
            @RequestBody Prenotazione prenotazione)
    {
        System.out.println("Sono entrato senza ciao");
        List<Stanza> arrc = this.servImpl.listaStanzePerTipologia(prenotazione);
        return arrc;
    }

    //METODI PRENOTAZIONE
    @RequestMapping(value ={"/getPrenotazione"})
    @ResponseBody
    public Prenotazione getPrenotazione(@RequestBody Long id)
    {
        return this.servImpl.getPrenotazione(id);
    }
    
    
    @RequestMapping(value ={"/prenotazione"})
    @ResponseBody
    public Prenotazione nuovaPrenotazione(@RequestBody Prenotazione prenotazione)
    {
        return this.servImpl.nuovaPrenotazione(prenotazione);
    }

    @RequestMapping(value={"/prenotazioniUtente"})
    @ResponseBody
    public List<Prenotazione> PrenotazioniById(
    @RequestBody Long id){
        return this.servImpl.listaPrenotazioniUtente(id);
    }

    
    @RequestMapping(value="/listaPrenotazioni")
    @ResponseBody
    public List<Prenotazione> listaPrenotazioni(){
        return this.servImpl.listaPrenotazioni();
    }
    
    @RequestMapping(value ={"/modificaPrenotazione"})
    @ResponseBody
    public void modificaPrenotazione(@RequestBody Prenotazione prenotazione)
    {
        this.servImpl.modificaPrenotazione(prenotazione);
    }
    @RequestMapping(value ={"/cancellaPrenotazione"})
    @ResponseBody
    public void cancellaPrenotazione(@RequestBody Prenotazione prenotazione)
    {
        this.servImpl.cancellaPrenotazione(prenotazione);
    }

    
    @RequestMapping(value ={"/findOspiteByDocumento"})
    @ResponseBody
    public Ospite findByDocumento(@RequestBody String documento)
    {
        return this.servImpl.findByDocumento(documento);
    }

    
    //METODI SERVIZI
    @RequestMapping(value ={"/servizi"})
    @ResponseBody
    public List<Servizio> listaServizi()
    {
        return this.servImpl.listaServizi();
    }
    
}
