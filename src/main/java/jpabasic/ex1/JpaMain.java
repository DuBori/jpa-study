package jpabasic.ex1;

import jpabasic.ex1.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");

        EntityManager em = enf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Movie movie = new Movie("봉준호", "원빈", "바람과함께사라지다.");
            em.persist(movie);

            em.flush();
            em.clear();

            Movie movie1 = em.find(Movie.class, movie.getId());
            System.out.println("movie1 = " + movie1);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        enf.close();
    }
}
