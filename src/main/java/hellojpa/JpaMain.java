package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // persistence.xml에서 import한 javax에 있는 Persistence이다.
        // persistence.xml의 유닛 네임인 hello를 넣는다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // db 연결 등 다양한게 된 거다.

        EntityManager em = emf.createEntityManager();

        // 데이터베이스 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        // 데이터가 변경되는 모든 작업은 트랜잭션 안에서 실행되어야 한다.

        try {
            // 저장
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

            // 수정
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            // 수정은 em.persist 안 해도 됨. JPA를 통해 가져오면 JPA가 관리함. 트랜잭션 시점에 변경 여부를 체크한다. 바꼈으면 update 쿼리를 만들어서 날리고 트랜잭션이 커밋된다.
//            findMember.setName("HelloJPA");

//            // jpql. 객체를 대상으로 쿼리를 짠다. 대상이 테이블이 아닌 객체이다. 객체지향 쿼리.
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(10) // 페이지네이션 하는 것이 정말 좋다. 알아서 디비에 맞게 번역해준다.
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

//            // 비 영속상태.
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속상태.
//            em.persist(member);
//
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L); // 쿼리가 한 번만 나감. 조회하면 영속성 콘텍스트에 올리기 때문에 이미 캐시에 들어있기 때문.
//
//            // == 비교가 true임을 보장해 준다. 1차 캐시를 해주기 때문.
//            System.out.println("findMember2 == findMember1 = " + (findMember2 == findMember1));

//            // 조회하는데 셀렉트 쿼리가 안 나감. 1차 캐시에 있는 걸 조회하기 때문.
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());


//            // 준 영속상태.
//            em.detach(member); // 영속성 콘텍스트에서 분리한다.
//
//            // 객체를 지운다.
//            em.remove(member);

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            // 영속성 컨텍스트에 쌓이게 된다.
//            // 이 때 디비에 쿼리 날려버리면 최적화 할 여지가 없다.
//            em.persist(member1);
//            em.persist(member2);
//
//            // 버퍼 사용 가능
//
            // 알아서 update쿼리 실행해 준다. 값만 바꿔도 된다. update해줘! 가 필요 없는 거다. 더티체킹. 변경감지를 해 줌.
//            Member member = em.find(Member.class, 150L);
//            member.setName("zzzz");

//            if (member.getName().equals("zzzz")) {
//                em.update(member); --> 멤버가 변경된 경우에만 날릴거야!!! 근데 이런 걸 안 해도 무조건 update 쿼리가 날라간다. 그래서 이런 걸 하면 안 된다.
//            }

//            em.persist(member); <-- 쓰면 안 된다. JPA가 자바 컬렉션 다루듯이 다루는 게 목표. 값 변경하면 끝.


//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); // 플러시 강제 호출 --> 데이터베이스에 인서트 쿼리가 즉시 나가고 그 다음에 커밋된다. 플러시 해도 1차 캐시는 지워지지 않는다. 영속성 컨텍스트의 쓰기지연 저장소에 있는 애들만 디비에 반영된다.
//            // em.persist해도 쿼리는 안 날라간다. 이렇게 해 놓고 조회하면 조회가 안 된다. 왜냐면 아직 디비에 쿼리가 안 날라갔기 때문. JPQL은 이런 에러를 방지하기 위해 플러시를 강제로 실행한다.


//            // 영속상태이다.
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");

//            em.detach(member); // JPA가 관리하지 않는다. 영속성 컨텍스트에서 빠진다. 준영속 상태.
//            em.clear(); // 영속성 컨텍스트를 통채로 다 지워버린다. 준영속 상태.
//            Member member2 = em.find(Member.class, 150L); // 똑같은 애가 없다고 인식하고 또 올려버린다.
//            em.close(); // 영속성 컨텍스트 종료

//            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);
//
//            em.persist(member);

            // Generated value
            Member member = new Member();
            member.setUsername("C");
            em.persist(member);
            System.out.println(" ================= ");

            // commit 했을 때 쿼리가 날라간다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            // 사용을 다 하고 나면 꼭 닫아주어야 한다.
            em.close();
        }

        emf.close();

    }
}
