package com.example.demo.Service;

import com.example.demo.Bean.Commande;
import com.example.demo.Dao.CommandeDao;
import com.google.api.services.pagespeedonline.PagespeedonlineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService {
    @Autowired private CommandeDao commandeDao;

    public Commande findByReference(String reference){
        return commandeDao.findByReference(reference);
    }
    public List<Commande> findAll(){
        return commandeDao.findAll();
    }

    public List<Commande> findByReferenceContains(String reference){
        return commandeDao.findByReferenceContains(reference);
    }

    public int save(Commande commande)
    {
        Commande commande1=commandeDao.findByReference(commande.getReference());
        if(commande1!=null){
            return -1;
        }
        else {
            if(commande.getMontantPayeCheque()+commande.getMontantPayeEspace()==0){
                return -3;
            }
            commande.setDateCreation(new Date());
            commande.setArchived(false);
            commande.setDernierPaiement(new Date());
            commandeDao.save(commande);
            return 1;
        }
    }
    public int archiveByReference(   String reference){
        Commande commande=commandeDao.findByReference(reference);
        if(commande==null){
            return -1;
        }
        else {
            commande.setArchived(true);
            commandeDao.save(commande);
            return 1;
        }
    }    public int deleteByReference(String reference){
        Commande commande=commandeDao.findByReference(reference);
        if(commande==null){
            return -1;
        }
        else {
            commandeDao.deleteByReference(reference);
            return 1;
        }
    }
    public List<Commande> findyByCrationDate(Date date){
        return  commandeDao.findAllByDateCreation(date);
    }
public void test(String page,String  strategy){

    final String uri = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed?url=" +page+
            "&key=&strategy="+strategy+"&prettyprint=true&category=performance&" +
            "category=pwa&category=best-practices&category=accessibility&category=seo";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);

    System.out.println(result);}
}
