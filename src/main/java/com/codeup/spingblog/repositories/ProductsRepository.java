package com.codeup.spingblog.repositories;

import com.codeup.spingblog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository <Product, Long>{

}
