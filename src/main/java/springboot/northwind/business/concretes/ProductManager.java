package springboot.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_categoryId(productName, categoryId),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory(productName, categoryId),"Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"Data Listed.");
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
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId),"Data Listed.");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Success!");
	}

}
