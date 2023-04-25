package hello.jpashop.model.category.domain;

import hello.jpashop.model.item.domain.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    protected Category() {
    }

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

    private void addParent(Category parent) {
        this.parent = parent;
    }

    public void addChildCategory(Category child) {
        this.children.add(child);
        child.addParent(this);
    }
}
