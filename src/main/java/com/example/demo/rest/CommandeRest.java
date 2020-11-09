package com.example.demo.rest;

import com.example.demo.Bean.Commande;
import com.example.demo.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeRest {

    @Autowired CommandeService commandeService;


    @PostMapping("/save")
    public int save(@RequestBody Commande commande)
    {
        return commandeService.save(commande);
    }
    @PutMapping("/archive/{reference}")
    public int archive(@PathVariable  String reference)
    {
        return commandeService.archiveByReference(reference);
    }

}
