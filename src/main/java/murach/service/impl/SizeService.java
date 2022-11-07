package murach.service.impl;

import java.util.List;

import javax.inject.Inject;

import murach.dao.ISizeDAO;
import murach.model.SizeModel;
import murach.service.ISizeService;

public class SizeService implements ISizeService {
	
	@Inject
	private ISizeDAO sizeDao;

	@Override
	public List<SizeModel> findAll() {
		
		return sizeDao.findAll();
	}

}
