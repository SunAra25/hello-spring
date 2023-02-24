package hello.hellospring.reposiotory;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // JPA는 EntityManager로 모든걸 동작
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        // return 값이 없지만 현재 구현해둔 스펙에 맞추기 위해 member 반환
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // em.find(조회할 타입, 식별자)
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체를 기준으로 쿼리문 전송 -> sql로 변역
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
