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
            Member member1 = em.find(Member.class, 3L);
            Member member2 = em.find(Member.class, 3L);

            /* 1차 캐시 메모리 조회 -> db조회*/
            System.out.println("member1 = " + member1);
            /* 1차 캐시 메모리 조회*/
            System.out.println("member2 = " + member2);

            /*영속성 엔티티 동일 트랜잭션 내에 동일성 보장*/
            System.out.println("member2.equals(member1) = " + member2.equals(member1));


            /*
            *default 쿼리 보내는 시점
            * EntityManger에 새로운 객체를 넣을시에
            * 1차 캐시 메모리에 저장하며, sql 쓰기 지연 메모리에
            * 해당 쿼리문을 저장하고
            * 아래 해당 메서드가 실행될 때 쿼리들이 모아 실행된다.
            * */
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        enf.close();
    }
}
