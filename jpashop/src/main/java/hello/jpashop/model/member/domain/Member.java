package hello.jpashop.model.member.domain;

import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.order.domain.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    protected Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
