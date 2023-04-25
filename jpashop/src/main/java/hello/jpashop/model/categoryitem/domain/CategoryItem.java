package hello.jpashop.model.categoryitem.domain;

import hello.jpashop.model.category.domain.Category;
import hello.jpashop.model.item.domain.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    protected CategoryItem() {
    }

    public CategoryItem(Category category, Item item) {
        this.category = category;
        this.item = item;
    }
}
