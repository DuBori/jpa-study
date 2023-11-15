package jpabasic.ex1;

import jpabasic.ex1.entity.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {

            Team team = new Team("team1");
            em.persist(team);

            Team team2 = new Team("team2");
            em.persist(team2);

            Member member = new Member("mem1", 10, team);
            em.persist(member);
            Member member2 = new Member("mem2", 11, team);
            em.persist(member2);
            Member member3 = new Member("mem3", 12, team2);
            em.persist(member3);

            em.flush();
            em.clear();
            TypedQuery<Member> memberTypedQuery = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "mem1");
            Member singleResult = memberTypedQuery.getSingleResult();
            System.out.println("singleResult = " + singleResult);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
