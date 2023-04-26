package hello.jpashop.model.member.service;

import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.member.dto.MemberResponse;
import hello.jpashop.model.member.dto.MemberSignUpRequest;

public class MemberAssembler {

    public static MemberResponse toDto(Member member) {
        return new MemberResponse(member.getId(), member.getName());
    }

    public static Member toEntity(MemberSignUpRequest memberSignUpRequest) {
        Address address = new Address(memberSignUpRequest.getCity(), memberSignUpRequest.getStreet(), memberSignUpRequest.getZipcode());
        return new Member(memberSignUpRequest.getName(), address);
    }
}
