package murach.dao;

import java.util.List;

import murach.model.AboutModel;

public interface IAboutDAO extends GenericDAO<AboutModel> {
	AboutModel findOne(Long id);
	
	Long save(AboutModel aboutModel);
	
	void update(AboutModel updateAbout);
	
	void delete(long id);
	
	List<AboutModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	List<AboutModel> findAllAbout();
}
