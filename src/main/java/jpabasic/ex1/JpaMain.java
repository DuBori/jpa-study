package jpabasic.ex1;

import jpabasic.ex1.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");

        /*하나의 트랜잭션 단위 EntityManger*/
        EntityManager em = enf.createEntityManager();

        /*DB Connection 하나 받는 느낌*/
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member(2L, "정훈");
            em.persist(member);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
            enf.close();
        }



    }
}
