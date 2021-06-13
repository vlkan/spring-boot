package springboot.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.northwind.entities.concretes.Product;
import springboot.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_categoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productname);
	
	List<Product> getByProductNameStartsWith(String productname);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")//not working with db. working with JAVA value.
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	@Query("select new springboot.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) from Category c inner join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
