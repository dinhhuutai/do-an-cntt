package murach.service;

import java.util.List;

import murach.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
