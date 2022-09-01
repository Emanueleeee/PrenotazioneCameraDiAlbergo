/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package angular.spring.ngspring.model.service;

import angular.spring.ngspring.model.Ospite;
import angular.spring.ngspring.model.Prenotazione;
import angular.spring.ngspring.model.Servizio;
import angular.spring.ngspring.model.Stanza;
import angular.spring.ngspring.model.Tipologia;
import angular.spring.ngspring.model.Utente;
import java.util.List;

/**
 *
 * @author hutti
 */
public interface Services {
    //MEtodi Utente
    public Boolean registrazione(Utente utente);
    public Utente accesso(Utente utente);

    //Metodi tipologia
    public List<Tipologia> listaTipologia();
    public Tipologia trovaTipologia(Long id);

    //Metodi prenotazioni
    public Prenotazione nuovaPrenotazione(Prenotazione prenotazione);
    public void modificaPrenotazione(Prenotazione prenotazione);
    public void cancellaPrenotazione(Prenotazione prenotazione);
    public List <Prenotazione> listaPrenotazioniUtente(Long id);
    public List<Prenotazione> listaPrenotazioni();
    public Prenotazione getPrenotazione(Long id);

    //metodi servizi
    public List<Servizio> listaServizi();
    //metodi stanza
    public List<Stanza> listaStanzePerTipologia(Prenotazione prenotazione);
    public Ospite findByDocumento(String documento);
 
}
