package com.example.CategoryCrud.Service;

import com.example.CategoryCrud.Entity.Product;
import com.example.CategoryCrud.Repository.CategoryRepository;
import com.example.CategoryCrud.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> getAllProducts(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product){
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
