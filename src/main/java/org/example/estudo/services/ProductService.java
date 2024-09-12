package org.example.estudo.services;

import org.example.estudo.entities.Product;
import org.example.estudo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository categoryRepository;

    public List<Product> findAll(){
        return categoryRepository.findAll();

    }

    public Optional<Product> findById(Long id){
        return categoryRepository.findById(id);
    }
}
