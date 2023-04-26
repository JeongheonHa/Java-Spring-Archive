package hello.jpashop.model.member.dto;

import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.domain.vo.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberSignUpRequest {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    private String city;
    private String street;
    private String zipcode;


    public Member toEntity(String name, String city, String street, String zipcode) {
        Address address = new Address(city, street, zipcode);
        Member member = new Member(name, address);
        return member;
    }
}
