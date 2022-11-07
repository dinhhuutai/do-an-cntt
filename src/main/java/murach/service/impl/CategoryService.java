package murach.service.impl;

import java.util.List;

import javax.inject.Inject;

import murach.dao.ICategoryDAO;
import murach.model.CategoryModel;
import murach.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;
	

	@Override
	public List<CategoryModel> findAll() {
		
		
		return categoryDao.findAll();
	}

}
