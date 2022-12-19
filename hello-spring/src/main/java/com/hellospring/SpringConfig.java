package com.hellospring;

import com.hellospring.repository.JdbcTemplateMemberRepository;
import com.hellospring.repository.JpaMemberRepository;
import com.hellospring.repository.MemberRepository;
import com.hellospring.repository.MemoryMemberRepository;
import com.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // injection을 받아서 의존 관계를 셋팅하면 된다.
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

/*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/
/*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
*/

    @Bean   // 멤버 서비스에 의존 관계 셋팅
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
