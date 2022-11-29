package com.mnr.catalogueservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
//si on met ToString annotation ça genere une boucle infinie
public class Category {

    @Id
    private String id;
    private String name;

    @DBRef
    //@DBRef:dans l document category je ne vais enregistrer que l'id du produit
    private Collection<Product> products= new ArrayList<>() ;
}
