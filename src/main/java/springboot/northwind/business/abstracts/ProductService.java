package springboot.northwind.business.abstracts;

import java.util.List;

import springboot.northwind.core.utilities.results.DataResult;
import springboot.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
}
