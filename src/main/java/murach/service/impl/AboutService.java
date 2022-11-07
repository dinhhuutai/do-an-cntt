package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.IAboutDAO;
import murach.model.AboutModel;
import murach.service.IAboutService;

public class AboutService implements IAboutService {
	
	@Inject
	private IAboutDAO aboutDao;

	@Override
	public AboutModel findOne(Long id) {
		AboutModel aboutModel = aboutDao.findOne(id);

		return aboutModel;
	}

	@Override
	public AboutModel save(AboutModel aboutModel) {
		aboutModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		

		Long aboutId = aboutDao.save(aboutModel);
		
		return aboutDao.findOne(aboutId);
	}

	@Override
	public AboutModel update(AboutModel updateAbout) {
		AboutModel oldAbout = aboutDao.findOne(updateAbout.getId());

		updateAbout.setCreatedDate(oldAbout.getCreatedDate());
		updateAbout.setCreatedBy(oldAbout.getCreatedBy());
		updateAbout.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		

		aboutDao.update(updateAbout);

		return aboutDao.findOne(updateAbout.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1. delete comment (khoa ngoai new_id)
			
			//2. delete news
			aboutDao.delete(id);
		}
	}

	@Override
	public List<AboutModel> findAll(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return aboutDao.findAll(index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		return aboutDao.getTotalItem();
	}

	@Override
	public List<AboutModel> findAllAbout() {
		return aboutDao.findAllAbout();
	}

}
