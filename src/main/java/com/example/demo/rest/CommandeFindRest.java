package com.example.demo.rest;
import com.example.demo.Bean.Commande;
import com.example.demo.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeFindRest {
    @Autowired
    CommandeService commandeService;
    @GetMapping("/c")
    public List<Commande> findAll(){
        return commandeService.findAll();
    }
    @GetMapping("/")
    public void getData(){
         commandeService.test("https://stackoverflow.com/","mobile");
    }
    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference){
        return commandeService.findByReference(reference);
    }
    @GetMapping("/ReferenceContains/{reference}")
    public List<Commande> findByReferenceContains(@PathVariable  String reference){
        return commandeService.findByReferenceContains(reference);
    }
    @GetMapping("/creationDate/{creationDate}")
    public List<Commande> findyByCrationDate(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date){
        return commandeService.findyByCrationDate(date);
    }


}
