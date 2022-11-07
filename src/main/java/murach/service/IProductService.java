package murach.service;

import java.util.List;

import murach.model.ProductModel;

public interface IProductService {
	List<ProductModel> findByCategoryId(long categoryId);

	ProductModel save(ProductModel productModel);

	ProductModel update(ProductModel updateProduct);

	void delete(long[] ids);

	List<ProductModel> findAll(int index, int itemInPage);

	int getTotalItem();
	
	ProductModel findOne(Long id);

	List<ProductModel> findProductNew(int itemProductNew);

	List<ProductModel> getNext20Product(int amount, String category, String sort, String price, String color, String name);

	List<ProductModel> getNext20ProductSearch(String category, String sort, String price, String color, String name);

	ProductModel updatePopularity(Long id, Long popularity);

	List<ProductModel> findTop10ProductPopularity();

	List<ProductModel> searchProduct(String name);
}
