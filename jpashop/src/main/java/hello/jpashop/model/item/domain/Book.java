package hello.jpashop.model.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
public class Book extends Item {

    private String author;
    private int isbn;

    protected Book() {
    }

    @Builder
    public Book(String name, int price, int stockQuantity, String author, int isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn);
    }
}
