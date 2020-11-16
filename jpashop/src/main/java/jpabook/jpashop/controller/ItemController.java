package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
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
    public String creatForm(Model model){
        model.addAttribute("form" , new BookFrom());
        return "items/creatItemForm";
    }
    @PostMapping("/items/new")
    public String create(BookFrom form){
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items",items);
        return "items/itemList";
    }

    @GetMapping("/items/{itemid}/edit")
    public String updateItemForm(@PathVariable("itemid") Long itemid,Model model){
        Book item= (Book) itemService.findOne(itemid);

        BookFrom from = new BookFrom();
        from.setId(item.getId());
        from.setName(item.getName());
        from.setPrice(item.getPrice());
        from.setStockQuantity(item.getStockQuantity());
        from.setAuthor(item.getAuthor());
        from.setIsbn(item.getIsbn());

        model.addAttribute("form",from);
        return "items/updateItemForm";

    }

    @PostMapping("item/{itemid}edit")
    public String updateItem(@PathVariable String itemid , @ModelAttribute("form") BookFrom form){
        Book book = new Book();

        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:items";
    }
}
