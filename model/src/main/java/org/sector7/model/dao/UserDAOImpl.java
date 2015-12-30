package org.sector7.model.dao;

import org.sector7.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by s.zakipour on 12/27/2015.
 */
public class UserDAOImpl
{
    private static final EntityManagerFactory entityManagerFactory;
    static{
        entityManagerFactory  = Persistence.createEntityManagerFactory("MyConnection");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }


    public User getUser(String user, String password) {
        try
        {
             return (User) getEntityManagerFactory().createEntityManager().createNamedQuery("User.findByUserAndPass")
                    .setParameter("username" , user)
                    .setParameter("password" , password)
                    .getSingleResult();

//            em.createNamedQuery("User.")

        } catch (Exception ex) {

            return  null;
        }

    }


}
