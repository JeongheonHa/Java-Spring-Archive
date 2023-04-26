package hello.jpashop.model.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {

    private Long id;
    private String name;

    public MemberResponse() {
    }

    public MemberResponse(String name) {
        this.name = name;
    }

    public MemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
