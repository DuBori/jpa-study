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
            Member member = new Member(new AddressEntity("hi","hi","hi"));

            member.getFavoriteFoods().add("라면");
            member.getFavoriteFoods().add("컵라면");
            member.getFavoriteFoods().add("라면컵");

            member.getAddressEntities().add(new AddressEntity("hi2","hi","hi"));
            member.getAddressEntities().add(new AddressEntity("hi3","hi","hi"));

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            findMember.getFavoriteFoods().remove("라면");
            findMember.getFavoriteFoods().add("라볶이");

            findMember.getAddressEntities().remove(new AddressEntity("hi2","hi","hi"));
            member.getAddressEntities().add(new AddressEntity("hi5","hi5","hi5"));

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
