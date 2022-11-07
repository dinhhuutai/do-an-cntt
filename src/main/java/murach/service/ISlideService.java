package murach.service;

import java.util.List;

import murach.model.SlideModel;

public interface ISlideService {

	SlideModel findOne(Long id);
	
	SlideModel save(SlideModel slideModel);
	
	SlideModel update(SlideModel updateSlide);
	
	void delete(long[] ids);
	
	List<SlideModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	List<SlideModel> findAllSlide();
}
