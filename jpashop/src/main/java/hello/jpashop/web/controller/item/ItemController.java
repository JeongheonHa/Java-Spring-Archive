package hello.jpashop.web.controller.item;

import hello.jpashop.model.item.domain.Book;
import hello.jpashop.model.item.domain.Item;
import hello.jpashop.model.item.domain.dto.BookRequest;
import hello.jpashop.model.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String itemForm(Model model) {
        model.addAttribute("form",new BookRequest());
        return "createItemForm";
    }

    @PostMapping("/items/new")
    public String createItem(BookRequest request) {
        Book book = Book.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();

        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String createEditForm(@PathVariable Long itemId, Model model) {

        Book item = (Book) itemService.findById(itemId);

        BookRequest form = new BookRequest();

        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookRequest form) {

        itemService.updateItem(form.getId(), form.getName(), form.getPrice(), form.getStockQuantity());

        return "redirect:/items";
    }
}
