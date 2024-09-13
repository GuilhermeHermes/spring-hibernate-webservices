package org.example.estudo.resources;

import org.example.estudo.entities.Order;
import org.example.estudo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> FindAll(){
        List<Order> ordersList = service.findAll();
        return ResponseEntity.ok().body(ordersList);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        try {
            Optional<Order> order = service.findById(id);
            if (order.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Order with ID " + id + " not found.");
            }
            return ResponseEntity.ok().body(order);
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred.");
        }
    }

    @RequestMapping(value = "/total/{id}")
    public ResponseEntity<?> getTotal(@PathVariable Long id){
        Double total = service.getTotal(id);
        return ResponseEntity.ok().body(total);
    }
}
