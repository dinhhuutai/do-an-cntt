package murach.service;

import java.util.List;

import murach.model.BannerModel;

public interface IBannerService {

	BannerModel findOne(Long id);
	
	BannerModel save(BannerModel bannerModel);
	
	BannerModel update(BannerModel updateBanner);
	
	void delete(long[] ids);
	
	List<BannerModel> findAll(int index, int itemInPage);
	
	int getTotalItem();

	List<BannerModel> findAllBanner();
	
	List<BannerModel> find2Banner();

	List<BannerModel> find3Banner();
}
