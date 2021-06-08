package springboot.northwind.business.abstracts;

import java.util.List;


import springboot.northwind.core.utilities.results.DataResult;
import springboot.northwind.core.utilities.results.Result;
import springboot.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productname);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productname);
	
	DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId);
}
