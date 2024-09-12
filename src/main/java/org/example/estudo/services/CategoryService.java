package org.example.estudo.services;

import org.example.estudo.entities.Category;
import org.example.estudo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();

    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
}
