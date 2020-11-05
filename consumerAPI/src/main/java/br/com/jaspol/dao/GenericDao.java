/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.dao;

import br.com.jaspol.domain.Eletronico;
import br.com.jaspol.domain.Pessoa;
import br.com.jaspol.model.ChangePass;
import br.com.jaspol.model.Eletro;
import br.com.jaspol.model.User;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author compliancedev03
 */
public class GenericDao {
    private EntityManager em = null;
    private EntityManagerFactory emf = null;
    private EntityTransaction tx = null;

    public void openConnec() {

        emf = Persistence.createEntityManagerFactory("br.com.jaspol_consumerAPI_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();

    }

    public void fechaConnec() {
        if (this.em != null ) {
            this.em.clear();
            this.em.close();
            this.emf.close();
        }
    }

    
    public Object merge(Object a){
        tx = em.getTransaction();
        tx.begin();
        this.em.merge(a);
        tx.commit();
        return a;
    }

    public Object find(Class enClass, Object a) {   
        this.em.find(enClass, a);
        return a;
    }    

    
    public Object remove(Object a) {
        tx = em.getTransaction();
        tx.begin();
        this.em.merge(a);
        em.remove(a);
        tx.commit();
        return a;
    }
    
     public Eletronico buscaEletro(Eletro eletronico){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT e FROM Eletronico e ")
                    .append(" WHERE e.name = :name ")
                    .append(" AND e.marca = :marca ")
                    .append(" AND e.potencia = :potencia ");
            TypedQuery<Eletronico> query = em.createQuery(sqlBuilder.toString(), Eletronico.class);
            query.setParameter("name", eletronico.getName().toLowerCase());
            query.setParameter("potencia", new BigInteger(eletronico.getPotencia().toString()));
            query.setParameter("marca", eletronico.getMarca().toLowerCase());
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    }
     
     
     public Eletronico buscaEletroId(int id){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT e FROM Eletronico e ")
                    .append(" WHERE e.id = :id ");
            TypedQuery<Eletronico> query = em.createQuery(sqlBuilder.toString(), Eletronico.class);
            query.setParameter("id", id);
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    } 
    
      public List<Eletronico> buscaEletroPessoaId(int id){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT e FROM Eletronico e ")
                    .append(" WHERE e.pessoaIdFk.id = :id ");
            TypedQuery<Eletronico> query = em.createQuery(sqlBuilder.toString(), Eletronico.class);
            query.setParameter("id", id);
            
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }      
    } 
    
    public Pessoa buscaPessoa(User user){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT p FROM Pessoa p ")
                    .append(" WHERE p.name = :name ")
                    .append(" AND p.email = :email ");
            TypedQuery<Pessoa> query = em.createQuery(sqlBuilder.toString(), Pessoa.class);
            query.setParameter("name", user.getName().toLowerCase());
            query.setParameter("email", user.getEmail().toLowerCase());
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    }
    
    public Pessoa buscaPessoaLoga(User user){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT p FROM Pessoa p ")
                    .append(" WHERE p.password = :pass ")
                    .append(" AND p.email = :email ");
            TypedQuery<Pessoa> query = em.createQuery(sqlBuilder.toString(), Pessoa.class);
            query.setParameter("pass", user.getPassword().toLowerCase());
            query.setParameter("email", user.getEmail().toLowerCase());
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    }
    
     public Pessoa buscaPessoaPass(ChangePass user){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT p FROM Pessoa p ")
                    .append(" WHERE p.password = :pass ")
                    .append(" AND p.email = :email ");
            TypedQuery<Pessoa> query = em.createQuery(sqlBuilder.toString(), Pessoa.class);
            query.setParameter("pass", user.getPassword().toLowerCase());
            query.setParameter("email", user.getEmail().toLowerCase());
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    }
    
    
    public Pessoa buscaPessoaId(int id){
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT p FROM Pessoa p ")
                    .append(" WHERE p.id = :id ");
            TypedQuery<Pessoa> query = em.createQuery(sqlBuilder.toString(), Pessoa.class);
            query.setParameter("id",id);
            
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }      
    }
    
    public Query query(){
        Query q = em.createNamedQuery("Pessoa.findAll", Pessoa.class);
        return q;
    }
    
     public Query queryEltro(){
        Query q = em.createNamedQuery("Eletronico.findAll",Eletronico.class);
        return q;
    }
    
}
