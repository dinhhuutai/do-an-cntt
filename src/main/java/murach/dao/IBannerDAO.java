package murach.dao;

import java.util.List;

import murach.model.BannerModel;

public interface IBannerDAO extends GenericDAO<BannerModel> {

	BannerModel findOne(Long id);
	
	Long save(BannerModel bannerModel);
	
	void update(BannerModel updateBanner);
	
	void delete(long id);
	
	List<BannerModel> findAll(int index, int itemInPage);
	
	int getTotalItem();

	List<BannerModel> findAllBanner();
	List<BannerModel> find2Banner();
	List<BannerModel> find3Banner();
}
