package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.IBannerDAO;
import murach.model.BannerModel;
import murach.service.IBannerService;

public class BannerService implements IBannerService {
	
	@Inject
	private IBannerDAO bannerDao;

	@Override
	public BannerModel findOne(Long id) {
		BannerModel bannerModel = bannerDao.findOne(id);

		return bannerModel;
	}

	@Override
	public BannerModel save(BannerModel bannerModel) {
		bannerModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		

		Long bannerId = bannerDao.save(bannerModel);
		
		return bannerDao.findOne(bannerId);
	}

	@Override
	public BannerModel update(BannerModel updateBanner) {
		BannerModel oldBanner = bannerDao.findOne(updateBanner.getId());

		updateBanner.setCreatedDate(oldBanner.getCreatedDate());
		updateBanner.setCreatedBy(oldBanner.getCreatedBy());
		updateBanner.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		

		bannerDao.update(updateBanner);

		return bannerDao.findOne(updateBanner.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1. delete comment (khoa ngoai new_id)
			
			//2. delete news
			bannerDao.delete(id);
		}
	}

	@Override
	public List<BannerModel> find2Banner() {
		return bannerDao.find2Banner();
	}

	@Override
	public List<BannerModel> find3Banner() {
		return bannerDao.find3Banner();
	}

	@Override
	public List<BannerModel> findAllBanner() {
		return bannerDao.findAllBanner();
	}

	@Override
	public List<BannerModel> findAll(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return bannerDao.findAll(index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		return bannerDao.getTotalItem();
	}

}
