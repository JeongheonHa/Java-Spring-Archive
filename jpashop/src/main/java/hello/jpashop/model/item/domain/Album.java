package hello.jpashop.model.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
public class Album extends Item {

    private String artist;
    private String etc;

    protected Album() {
    }

    @Builder
    public Album(String name, int price, int stockQuantity, String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(artist, album.artist) && Objects.equals(etc, album.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, etc);
    }
}
