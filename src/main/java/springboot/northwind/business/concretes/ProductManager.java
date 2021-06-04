package springboot.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.northwind.business.abstracts.ProductService;
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
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productDao.findAll();
	}

}
