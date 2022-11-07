package murach.dao;

import java.util.List;

import murach.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	
	CategoryModel findOne(long id);

	CategoryModel findOneByCode(String code);
}
