package jpabasic.ex1;

import jpabasic.ex1.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");

        /*하나의 트랜잭션 단위 EntityManger*/
        EntityManager em = enf.createEntityManager();

        /*DB Connection 하나 받는 느낌*/
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = em.find(Member.class, 1L);
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)/*PageNation*/
                    .setMaxResults(10)/*PageNation*/
                    .getResultList();
            resultList.forEach(System.out::println);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
            enf.close();
        }



    }
}
