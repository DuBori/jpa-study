package jpabasic.ex1;

import jpabasic.ex1.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member("정현");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.getReference(Member.class, member.getId());
            boolean isLoaded = emf.getPersistenceUnitUtil().isLoaded(findMember);
            System.out.println("isLoaded = " + isLoaded);
            findMember.getTeam();
            isLoaded = emf.getPersistenceUnitUtil().isLoaded(findMember);
            System.out.println("isLoaded = " + isLoaded);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void test(Member member, Member member2) {

    }

}
