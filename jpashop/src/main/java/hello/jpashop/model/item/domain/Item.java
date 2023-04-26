package hello.jpashop.model.item.domain;

import hello.jpashop.model.item.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    protected Item() {
    }

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void popStock(int quantity) {
        int restStock = stockQuantity - quantity;

        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }

        this.stockQuantity = restStock;
    }

    public void changeNameAndPriceAndStockQuantity(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
