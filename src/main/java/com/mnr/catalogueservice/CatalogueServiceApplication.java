package com.mnr.catalogueservice;

import com.mnr.catalogueservice.Repositories.CategoryRepository;
import com.mnr.catalogueservice.Repositories.ProductRepository;
import com.mnr.catalogueservice.entities.Category;
import com.mnr.catalogueservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueServiceApplication.class, args);
    }


    //test
    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository){
        return args -> {
            categoryRepository.deleteAll(); //vider les categories a chaque demarrage

            Stream.of("C1 Ordinateur","C2 Imprimante","C3 Livres").forEach(c->{
                categoryRepository.save(new Category(c.split(" ")[0],c.split(" ")[1], new ArrayList<>()));
            });

            categoryRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();

            Category c1= categoryRepository.findById("C1").get();
            Stream.of("P1","P2","P3","P4").forEach(name->{
               Product p=productRepository.save(new Product(null,name,Math.random()*1000,c1));

                //add product to category: relation bi-directionnelle
                c1.getProducts().add(p);
                categoryRepository.save(c1); //save
            });

            Category c2= categoryRepository.findById("C2").get();
            Stream.of("P5","P6","P7","P8").forEach(name->{
                Product p=productRepository.save(new Product(null,name,Math.random()*1000,c2));
                //add product to category
                c2.getProducts().add(p);
                categoryRepository.save(c2); //save
            });

            Category c3= categoryRepository.findById("C3").get();
            Stream.of("P9","P10").forEach(name->{
                Product p=productRepository.save(new Product(null,name,Math.random()*1000,c3));
                //add product to category
                c3.getProducts().add(p);
                categoryRepository.save(c3); //save
            });

            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}


//31 min

