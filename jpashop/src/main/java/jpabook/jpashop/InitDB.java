package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
/*
* 총 주문 2개
**UserA
*   * JPA1 BOOK
*   * JPA2 BOOK
**USERB
*   * SPRING1 BOOK
*   * SPRING1 BOOK
*/
@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit1(){
            Member member = new Member();
            member.setName("userA");
            member.setAddress(new Address("서울","1","1111"));
            em.persist(member);

            Book book = new Book();
            book.setName("JPA1 BOOK");
            book.setPrice(10000);
            book.setStockQuantity(100);
            em.persist(book);

            Book book2 = new Book();
            book2.setName("JPA2 BOOK");
            book2.setPrice(20000);
            book2.setStockQuantity(100);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book, 10000, 1);
            OrderItem orderItem2= OrderItem.createOrderItem(book2,20000,2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order.createOrder(member,delivery,orderItem1,orderItem2);
        }
    }
}
