package org.example.estudo.configuration;

import org.example.estudo.entities.*;
import org.example.estudo.enums.OrderStatus;
import org.example.estudo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;

import java.time.Instant;
import java.util.Arrays;


@Profile("test")
@Configuration
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order1 = new Order(Instant.parse("2024-09-20T19:55:08Z"), OrderStatus.WAITING_PAYMENT, user1 );
        Order order2 = new Order(Instant.parse("2024-01-20T15:55:08Z"), OrderStatus.PAID, user1 );
        Order order3 = new Order(Instant.parse("2024-01-20T15:55:08Z"), OrderStatus.PAID, user2 );

        Category cat1 = new Category( "Electronics");
        Category cat2 = new Category( "Books");
        Category cat3 = new Category( "Computers");

        Product p1 = new Product( "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur...", 90.5, "");
        Product p2 = new Product( "Smart TV", "Nalla eu imperdiet purus. Macenas ante...", 2190.0, "");
        Product p3 = new Product( "Macbook Pro", "Nam eleifend maximus tortor, at mollis...", 1250.0, "");
        Product p4 = new Product( "PC Gamer", "Donec aliquet odio ac rhoncus cursus...", 1200.0, "");
        Product p5 = new Product( "Rails for Dummies", "Cras fringilla convallis sem vel faucibus...", 100.99, "");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);
        p4.getCategories().add(cat3);
        p4.getCategories().add(cat2);

        OrderItem oi1 = new OrderItem(order1, p1,  p1.getPrice(),2);
        OrderItem oi2 = new OrderItem(order1, p3, p3.getPrice(),1);
        OrderItem oi3 = new OrderItem(order2, p3, p3.getPrice(),2);
        OrderItem oi4 = new OrderItem(order3, p5, p5.getPrice(),2);

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));



    }
}
