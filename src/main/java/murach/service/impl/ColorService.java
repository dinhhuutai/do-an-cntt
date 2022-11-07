package murach.service.impl;

import java.util.List;

import javax.inject.Inject;

import murach.dao.IColorDAO;
import murach.model.ColoModel;
import murach.service.IColorService;

public class ColorService implements IColorService {
	
	@Inject
	private IColorDAO colorDao;

	@Override
	public List<ColoModel> findAll() {
		
		return colorDao.findAll();
	}

}
