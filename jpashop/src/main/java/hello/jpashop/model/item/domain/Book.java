package hello.jpashop.model.item.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Book extends Item {

    private String author;

    private int isbn;
}
