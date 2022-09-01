package angular.spring.ngspring.model.service;

import angular.spring.ngspring.model.Ospite;
import angular.spring.ngspring.model.Prenotazione;
import angular.spring.ngspring.model.Servizio;
import angular.spring.ngspring.model.Stanza;
import angular.spring.ngspring.model.Tipologia;
import angular.spring.ngspring.model.Utente;
import angular.spring.ngspring.model.repository.RepoPrenotazione;
import angular.spring.ngspring.model.repository.RepoStanza;
import angular.spring.ngspring.model.repository.RepoTipologia;
import angular.spring.ngspring.model.repository.RepoUtente;
import angular.spring.ngspring.model.repository.RepoServizio;
import angular.spring.ngspring.model.repository.RepoOspite;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesImpl implements Services
{

    @Autowired
    RepoUtente repoUtente;
    @Autowired
    RepoTipologia repoTipologia;
    @Autowired
    RepoStanza repoStanza;
    @Autowired
    RepoOspite repoOspite;
    @Autowired
    RepoServizio repoServizio;
    @Autowired
    RepoPrenotazione repoPrenotazione;

    //Metodi Utente
    @Override
    public Boolean registrazione(Utente utente)
    {
        if (repoUtente.findByUsername(utente.getUsername()) != null)
        {
            return false;
        } else
        {
            repoUtente.save(utente);
        }
        return true;
    }

    @Override
    public Utente accesso(Utente utente)
    {
        Utente utenteAcc = null;

        utenteAcc = repoUtente.findByUsernameAndPassword(utente.getUsername(), utente.getPassword());
//        utenteAcc.setPassword("");
        if (utenteAcc == null)
        {
            utenteAcc = new Utente();
            utenteAcc.setId(0L);
        }
        return utenteAcc;
    }

    //Metodi Tipologia
    @Override
    public List<Tipologia> listaTipologia()
    {
        return repoTipologia.findAll();
    }

    @Override
    public Tipologia trovaTipologia(Long id)
    {
        return repoTipologia.findById(id).get();
    }

    @Override
    public List<Stanza> listaStanzePerTipologia(Prenotazione prenotazione)
    {
        List<Prenotazione> listP = repoPrenotazione.findAll();
        List<Stanza> listS = repoStanza.findByTipologiaId(prenotazione.getStanza().getTipologia().getId());

        listP.removeIf(x
                -> x.getStanza().getTipologia().getId() != prenotazione.getStanza().getTipologia().getId());
        if (listP != null || !listP.isEmpty())
        {
            for (Prenotazione x : listP)
            {
                if ((prenotazione.getDataInizio().isAfter(x.getDataInizio()) && prenotazione.getDataInizio().isBefore(x.getDataFine()))
                        || (prenotazione.getDataFine().isAfter(x.getDataInizio()) && prenotazione.getDataFine().isBefore(x.getDataFine()))
                        && (x.getDataInizio().isAfter(prenotazione.getDataInizio()) && x.getDataInizio().isBefore(prenotazione.getDataFine()))
                        || (x.getDataFine().isAfter(prenotazione.getDataInizio()) && x.getDataFine().isBefore(prenotazione.getDataFine()))
                        || (prenotazione.getDataInizio().isEqual(x.getDataInizio()) || prenotazione.getDataFine().isEqual(x.getDataFine())))
                {
                    listS.remove(x.getStanza());
                }
            }
        }
        return listS;
    }

    //Metodi prenotazione
    @Override
    public List<Prenotazione> listaPrenotazioniUtente(Long id)
    {
        return repoPrenotazione.findAllByUtenteIdOrderByDataInizioDesc(id);
    }

    @Override

    public Prenotazione getPrenotazione(Long id)
    {
        return repoPrenotazione.findById(id).get();
    }

    @Override
    public Prenotazione nuovaPrenotazione(Prenotazione prenotazione)
    {
        return repoPrenotazione.save(prenotazione);
    }

    @Override
    public List<Prenotazione> listaPrenotazioni()
    {
        return repoPrenotazione.findAll();
    }

    @Override
    public void modificaPrenotazione(Prenotazione prenotazione)
    {
        repoPrenotazione.save(prenotazione);
    }

    @Override
    public void cancellaPrenotazione(Prenotazione prenotazione)
    {
        repoPrenotazione.delete(prenotazione);
    }

    
    @Override
    public Ospite findByDocumento(String documento)
    {

        return repoOspite.findByDocumento(documento);
    }


    @Override
    //Metodi servizi
    public List<Servizio> listaServizi()
    {
        return repoServizio.findAll();
    }

}
