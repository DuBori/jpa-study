package jpabasic.ex1;

import jpabasic.ex1.entity.Member;
import jpabasic.ex1.entity.Order;
import jpabasic.ex1.entity.OrderItem;
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
            Order order = new Order();
            order.addOrderItem(new OrderItem());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        enf.close();
    }
}
