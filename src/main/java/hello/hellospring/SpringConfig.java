package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.reposiotory.JDBCTemplateMemberRepository;
import hello.hellospring.reposiotory.JpaMemberRepository;
import hello.hellospring.reposiotory.MemberRepository;
import hello.hellospring.reposiotory.JDBCMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

    //직접 등록하는 방법
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository();
       // return new JDBCMemberRepository(dataSource);
       // return new JDBCTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);
//    }
 }
