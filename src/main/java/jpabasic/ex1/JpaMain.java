package jpabasic.ex1;

import jpabasic.ex1.entity.Member;
import jpabasic.ex1.entity.Team;
import jpabasic.ex1.enums.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");

        EntityManager em = enf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Team kia = new Team("KIA");
            em.persist(kia);

            Member o = new Member("정현", "서울", "독산", "어딘가", kia);
            em.persist(o);

            em.flush();
            em.clear();

            Member member = em.find(Member.class, o.getId());
            Team team = member.getTeam();
            System.out.println("team = " + team);

            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        enf.close();
    }
}
