package com.example.demo.Dao;

import com.example.demo.Bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandeDao  extends JpaRepository<Commande,Long> {
    public Commande findByReference(String reference);
    public int deleteByReference(String reference);
    public List<Commande> findByReferenceContains(String reference);
    public List<Commande> findAllByDateCreation(Date date);


}
