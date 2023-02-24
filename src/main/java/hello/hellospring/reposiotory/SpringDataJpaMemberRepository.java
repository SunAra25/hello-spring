package hello.hellospring.reposiotory;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//interface가 interface를 받을 때는 implements가 아니라 extends이고 다중 상속 가능
//인터페이스에 대한 구현체를 알아서 만들어서 bean에 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
