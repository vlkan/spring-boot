package springboot.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.northwind.business.abstracts.ProductService;
import springboot.northwind.core.utilities.results.DataResult;
import springboot.northwind.core.utilities.results.Result;
import springboot.northwind.core.utilities.results.SuccessDataResult;
import springboot.northwind.core.utilities.results.SuccessResult;
import springboot.northwind.dataAccess.abstracts.ProductDao;
import springboot.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.findAll(),"Data Listed.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product added");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(productDao.getByProductName(productName),"Data Listed.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(productDao.getByProductNameAndCategoryId(productName, categoryId),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategoryId(productName, categoryId),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIdIn(categories),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productname) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productname),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productname) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productname),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameAndCategory(productName, categoryId),"Data Listed.");
	}

}
