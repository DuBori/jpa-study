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
            Member member = em.find(Member.class, 6L);
            System.out.println("member = " + member);
            member.updateName("히히");
            /*
            * 준영속 상태 : 영속성 컨텍스트
            *             1차 캐시에 없는 상태
            * -> 조회만 하고 변경값에 대한 객체를 준영속상태로 만들어
            *   기존 스냅샷과 달라졌지만 아예 제거해서 변경대상에 포함되지
            *   않게됨.
            * */
            em.detach(member);
            /*em.clear(); - > 1차캐시 모두 클리어 */
            /*em.close(); - > 영속성 컨텍스트 종료 */
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        enf.close();
    }
}
