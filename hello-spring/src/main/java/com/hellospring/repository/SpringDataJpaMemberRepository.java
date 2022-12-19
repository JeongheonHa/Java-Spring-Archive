package com.hellospring.repository;

import com.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스만 만들어 놓고 스프링 데이터가 제공하는 jpa repository를 상속 받으면 스프링 데이터 jpa가 구현체를 만들어서 스프링 빈에 등록해 놓는다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
