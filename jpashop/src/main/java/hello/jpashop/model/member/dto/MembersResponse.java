package hello.jpashop.model.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MembersResponse<T> {
    private int count;
    private T data;
}
