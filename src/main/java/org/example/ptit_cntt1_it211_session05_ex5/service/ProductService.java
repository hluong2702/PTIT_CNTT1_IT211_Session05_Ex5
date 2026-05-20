package org.example.ptit_cntt1_it211_session05_ex5.service;

import org.example.ptit_cntt1_it211_session05_ex5.model.dto.ProductCreateDTO;
import org.example.ptit_cntt1_it211_session05_ex5.model.entity.Product;
import org.example.ptit_cntt1_it211_session05_ex5.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());
        product.setPrice(productCreateDTO.getPrice());
        product.setQuantity(productCreateDTO.getQuantity());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductCreateDTO productCreateDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productCreateDTO.getName());
            product.setDescription(productCreateDTO.getDescription());
            product.setPrice(productCreateDTO.getPrice());
            product.setQuantity(productCreateDTO.getQuantity());
            return productRepository.save(product);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
