package org.example.ptit_cntt1_it211_session05_ex5.respository;

import org.example.ptit_cntt1_it211_session05_ex5.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
