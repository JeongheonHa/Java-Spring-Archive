package hello.jpashop.model.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
public class Movie extends Item {

    private String director;
    private String actor;

    protected Movie() {
    }

    @Builder
    public Movie(String name, int price, int stockQuantity, String director, String actor) {
        super(name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(director, movie.director) && Objects.equals(actor, movie.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, actor);
    }
}
