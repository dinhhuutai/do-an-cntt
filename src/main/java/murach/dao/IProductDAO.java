package murach.dao;

import java.util.List;

import murach.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel> {
	ProductModel findOne(Long id);
	
	List<ProductModel> findByCategoryId(Long categoryId);
	
	Long save(ProductModel productModel);
	
	void update(ProductModel updateProduct);
	
	void delete(long id);
	
	List<ProductModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	List<ProductModel> findAllColor(long id);
	
	List<ProductModel> findProductNew(int itemProductNew);

	List<ProductModel> getNext20Product(int amount, String category, String sort, String price, String color, String name);
	
	List<ProductModel> getNext20ProductSearch(String category, String sort, String price, String color, String name);
	
	void updatePopularity(Long id, Long popularity);
	
	List<ProductModel> findTop10ProductPopularity();
	
	List<ProductModel> searchProduct(String name);
}
