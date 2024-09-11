package org.example.estudo.configuration;

import org.example.estudo.entities.Order;
import org.example.estudo.entities.User;
import org.example.estudo.enums.OrderStatus;
import org.example.estudo.repositories.OrderRepository;
import org.example.estudo.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order1 = new Order(Instant.parse("2024-09-20T19:55:08Z"), OrderStatus.WAITING_PAYMENT, user1 );
        Order order2 = new Order(Instant.parse("2024-01-20T15:55:08Z"), OrderStatus.PAID, user1 );
        Order order3 = new Order(Instant.parse("2024-01-20T15:55:08Z"), OrderStatus.PAID, user2 );

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }
}
