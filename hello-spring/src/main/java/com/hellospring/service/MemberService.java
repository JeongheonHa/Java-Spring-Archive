package com.hellospring.service;

import com.hellospring.domain.Member;
import com.hellospring.repository.MemberRepository;
import com.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 중복 회원 찾기.
        validDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     * @param member
     */
    private void validDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // null이 발생할 가능성이 있으면 Optional로 객체를 감싼다.
                .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
