package com.hellospring.repository;

import com.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 메서드가 끝날 때마다 클리어 해줘야한다.
    @AfterEach  // 메서드가 끝날 때마다 반복적으로 호출
    public void afterEach() {
        repository.clearStore();    // 공용으로 쓰는 데이터(store)들을 모두 지워줘야한다.
    }

    // 테스트는 순서를 보장하지 않기 때문에 모든 테스트는 메서드의 순서와 상관없이 따로 동작하도록 설계해야한다. (테스트간의 의존성이 없어야한다.)
    @Test
    public void save() {    // main 메서드 작성하는 것 처럼
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
