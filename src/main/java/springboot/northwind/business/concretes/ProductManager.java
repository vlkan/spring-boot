package springboot.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.northwind.business.abstracts.ProductService;
import springboot.northwind.core.utilities.results.DataResult;
import springboot.northwind.core.utilities.results.SuccessDataResult;
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

}
