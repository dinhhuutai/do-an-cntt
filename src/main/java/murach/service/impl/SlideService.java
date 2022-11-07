package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.ISlieDAO;
import murach.model.SlideModel;
import murach.service.ISlideService;

public class SlideService implements ISlideService {
	
	@Inject
	private ISlieDAO slideDao;

	@Override
	public SlideModel findOne(Long id) {
		SlideModel slideModel = slideDao.findOne(id);

		return slideModel;
	}

	@Override
	public SlideModel save(SlideModel slideModel) {
		slideModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		

		Long slideId = slideDao.save(slideModel);
		
		return slideDao.findOne(slideId);
	}

	@Override
	public SlideModel update(SlideModel updateSlide) {
		SlideModel oldSlide = slideDao.findOne(updateSlide.getId());

		updateSlide.setCreatedDate(oldSlide.getCreatedDate());
		updateSlide.setCreatedBy(oldSlide.getCreatedBy());
		updateSlide.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		

		slideDao.update(updateSlide);

		return slideDao.findOne(updateSlide.getId());
		
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1. delete comment (khoa ngoai new_id)
			
			//2. delete news
			slideDao.delete(id);
		}
	}

	@Override
	public List<SlideModel> findAll(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return slideDao.findAll(index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		return slideDao.getTotalItem();
	}

	@Override
	public List<SlideModel> findAllSlide() {
		return slideDao.findAllSlide();
	}

}
