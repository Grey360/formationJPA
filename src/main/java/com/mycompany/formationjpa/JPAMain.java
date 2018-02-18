/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formationjpa;

import com.mycompany.formationjpa.model.Article;
import com.mycompany.formationjpa.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gpetemoy
 */
public class JPAMain {
    
    public static void main(String[] args){
        
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("com.mycompany_formationJPA_jar_1.0-SNAPSHOTPU2");
        EntityManager em = emf.createEntityManager();
        
        User user = new User();
        
        // user.setId(Long.MIN_VALUE);
        user.setFirstName("Gailor");
        user.setLastName("Petemoya");
        user.setLogin("Gailor");
        user.setPassword("Gailor");

        user.setUserInfo("Gailor");
        
        // New article
        Article article = new Article();
        article.setAuthor(user);
        article.setTitle("Title");
        article.setContent("Content of the article");
        
        user.getArticles().add(article);
        
        // On persiste l'opération
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close(); // On ferme la connection à la DB
    }
}
