package com.nisum.demo.SunJeseyDemo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.demo.SunJeseyDemo.bo.ProductBO;

public interface ProductRepositary extends JpaRepository<ProductBO, Long>{
public List<ProductBO> findByCategory(Character ch);
}
