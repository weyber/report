package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Book;
import model.JPAUtil;

public class Dao implements Serializable, IDao{

    private static final long serialVersionUID = 1L;

    public List<Book> select() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Book> query;
        List<Book> books = null;

        try {
            query = em.createNamedQuery("findAll", Book.class);
            books = query.getResultList(); 
        }catch (Throwable exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            em.close();
        }
        return books;
    }
}
