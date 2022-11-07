package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.ICategoryDAO;
import murach.dao.IColorDAO;
import murach.dao.IProductDAO;
import murach.model.CategoryModel;
import murach.model.ColoModel;
import murach.model.ProductModel;
import murach.service.IProductService;

public class ProductService implements IProductService {

	@Inject
	private IProductDAO productDao;

	@Inject
	private ICategoryDAO categoryDao;
	
	@Inject
	private IColorDAO colorDao;
	

	@Override
	public List<ProductModel> findByCategoryId(long categoryId) {
		return productDao.findByCategoryId(categoryId);
	}

	@Override
	public ProductModel save(ProductModel productModel) {
		productModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		CategoryModel category = categoryDao.findOneByCode(productModel.getCategoryCode());
		productModel.setCategoryId(category.getId());
		
		ColoModel color = colorDao.findOneByCode(productModel.getColorCode());
		productModel.setColorId(color.getId());
		

		Long productId = productDao.save(productModel);
		
		return productDao.findOne(productId);
	}

	@Override
	public ProductModel update(ProductModel updateProduct) {
		ProductModel oldProduct = productDao.findOne(updateProduct.getId());

		updateProduct.setCreatedDate(oldProduct.getCreatedDate());
		updateProduct.setCreatedBy(oldProduct.getCreatedBy());
		updateProduct.setModifiedDate(new Timestamp(System.currentTimeMillis()));

		CategoryModel category = categoryDao.findOneByCode(updateProduct.getCategoryCode());
		updateProduct.setCategoryId(category.getId());
		

		ColoModel color = colorDao.findOneByCode(updateProduct.getColorCode());
		updateProduct.setColorId(color.getId());

		productDao.update(updateProduct);

		return productDao.findOne(updateProduct.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1. delete comment (khoa ngoai new_id)
			
			//2. delete news
			productDao.delete(id);
		}
	}

	@Override
	public List<ProductModel> findAll(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return productDao.findAll(index, itemInPage);
	}

	@Override
	public int getTotalItem() {

		return productDao.getTotalItem();
	}

	@Override
	public ProductModel findOne(Long id) {
		ProductModel productModel = productDao.findOne(id);

		CategoryModel categoryModel = categoryDao.findOne(productModel.getCategoryId());
		productModel.setCategoryCode(categoryModel.getCode());
		
		ColoModel colorModel = colorDao.findOne(productModel.getColorId());
		productModel.setColorCode(colorModel.getCode());
		

		return productModel;
	}

	@Override
	public List<ProductModel> findProductNew(int itemProductNew) {
		return productDao.findProductNew(itemProductNew);
	}

	@Override
	public List<ProductModel> getNext20Product(int amount, String category, String sort, String price, String color, String name) {
		name = "%" + name + "%";
		
		return productDao.getNext20Product(amount, category, sort, price, color, name);
	}

	@Override
	public List<ProductModel> getNext20ProductSearch(String category, String sort, String price, String color, String name) {
		name = "%" + name + "%";
		return productDao.getNext20ProductSearch(category, sort, price, color, name);
	}

	@Override
	public ProductModel updatePopularity(Long id, Long popularity) {

		productDao.updatePopularity(id, popularity);

		return productDao.findOne(id);
	}

	@Override
	public List<ProductModel> findTop10ProductPopularity() {
		return productDao.findTop10ProductPopularity();
	}

	@Override
	public List<ProductModel> searchProduct(String name) {
		name = "%" + name + "%";
		return productDao.searchProduct(name);
	}

}
