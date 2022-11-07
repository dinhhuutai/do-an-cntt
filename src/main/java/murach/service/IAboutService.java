package murach.service;

import java.util.List;

import murach.model.AboutModel;

public interface IAboutService {


	AboutModel findOne(Long id);
	
	AboutModel save(AboutModel aboutModel);
	
	AboutModel update(AboutModel updateAbout);
	
	void delete(long[] ids);
	
	List<AboutModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	List<AboutModel> findAllAbout();
}
