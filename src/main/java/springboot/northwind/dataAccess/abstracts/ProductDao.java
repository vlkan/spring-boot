package springboot.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productname);
	
	List<Product> getByProductNameStartsWith(String productname);
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")//not working with db. working with JAVA value.
	List<Product> getByProductNameAndCategory(String productName, int categoryId);
}
