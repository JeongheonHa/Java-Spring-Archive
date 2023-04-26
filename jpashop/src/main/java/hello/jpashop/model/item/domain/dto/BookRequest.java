package hello.jpashop.model.item.domain.dto;

import hello.jpashop.model.item.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private int isbn;
}
