package murach.dao;

import java.util.List;

import murach.model.SlideModel;

public interface ISlieDAO extends GenericDAO<SlideModel> {
	SlideModel findOne(Long id);
	
	Long save(SlideModel slideModel);
	
	void update(SlideModel updateSlide);
	
	void delete(long id);
	
	List<SlideModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	List<SlideModel> findAllSlide();
}
