package springboot.northwind.business.abstracts;

import java.util.List;

import springboot.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
	
}
