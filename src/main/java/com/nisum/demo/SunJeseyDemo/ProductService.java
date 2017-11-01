package com.nisum.demo.SunJeseyDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.demo.SunJeseyDemo.bo.ProductBO;
import com.nisum.demo.SunJeseyDemo.exception.ProductException;
import com.nisum.demo.SunJeseyDemo.repositary.ProductRepositary;

@Service
public class ProductService {
	@Autowired
	ProductRepositary productRepositary;

	public List<ProductBO> getAllProducts() throws ProductException {
		try {
			return productRepositary.findAll();

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}

	public List<ProductBO> getAllProductsByCategory(Character c) throws ProductException {
		try {
			return productRepositary.findByCategory(c);

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}
	public ProductBO getProductById(Long productID) throws ProductException {
		try {
			return productRepositary.findOne(productID);

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}

	public Object saveProduct(ProductBO productBO) throws ProductException {
		try {
			return productRepositary.save(productBO);

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}

	public void updateProduct(ProductBO productBO) throws ProductException {
		try {
			productRepositary.save(productBO);

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}

	public void deleteProduct(Long productID) throws ProductException {
		try {
			productRepositary.delete(productID);

		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
	}
}
