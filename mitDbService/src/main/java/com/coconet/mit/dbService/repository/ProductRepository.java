package com.coconet.mit.dbService.repository;

import com.coconet.mit.commons.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 16/10/17.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
