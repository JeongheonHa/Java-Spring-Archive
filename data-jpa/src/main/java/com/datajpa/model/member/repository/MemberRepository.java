package com.datajpa.model.member.repository;

import com.datajpa.model.member.domain.Member;
import com.datajpa.model.member.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 쿼리 메서드
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    // NamedQuery 정적 쿼리
    @Query(name = "Member.findByUsername") // 생략하면 선언한 도메인 클래스.메서드 이름으로 Named 쿼리를 찾아서 실행
    List<Member> findByUsername(@Param("username") String username);

    // 리파지토리에 메서드 쿼리 정의
    @Query("select m from Member m where m.username = :username and m.age = :age")
    Member findByAge(@Param("username") String username, @Param("age") Long age);

    // 기본형 타입 반환 (임베디드 타입도 동일)
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    // DTO로 직접 조회
    @Query("select new com.datajpa.member.domain.MemberDto(m.id, m.username, t.name) " + "from Member m join m.team t")
    List<MemberDto> findMemberDto();

    // 컬렉션 파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    // 벌크성 수정/삭제 쿼리
    @Modifying // @Modifying과 반환값이 void, int, Integer이면 된다.
    @Query("update Member m set m.age = m.age * 10 where m.username = :username")
    int bulkAgeUp(@Param("username") String username);

    /**
     * 반환 타입
     * List<Member> findByAge(int age); - 컬렉션
     * Member findByAge(int age); - 단건
     * Optional<Member> findByAge(int age); - 단건 Optional
     */


    // 페이징과 정렬
    Page<Member> findByAge(int age, Pageable pageable);

    // Slice<Member> findByAge(int age, Pageable pageable);

    /**
     * 페이징 성능 개선
     * ManyToOne 관계에서 Many를 대상으로 left join하면 Row의 갯수는 변하지 않는다.
     * 따라서, totalCount()로 조인한 테이블을 count(*)하는 것이 아닌 countQuery를 분라하여
     * Many를 대상으로 count(*)를 실행하면 성능을 개선할 수 있다.
     * @Query(value = "select m from Member m left join m.team t",
     *         countQuery = "select count(m) from Member m"
     * )
     * Page<Member> findByAge(int age, Pageable pageable);
     */
}
