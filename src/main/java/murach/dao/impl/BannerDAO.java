package murach.dao.impl;

import java.util.List;

import murach.dao.IBannerDAO;
import murach.mapper.BannerMapper;
import murach.model.BannerModel;

public class BannerDAO extends AbstractDAO<BannerModel> implements IBannerDAO {

	@Override
	public BannerModel findOne(Long id) {
		String sql = "select * from banner where id = ?";
		
		List<BannerModel> banner = query(sql, new BannerMapper(), id);
		
		return banner.isEmpty() ? null : banner.get(0);
	}

	@Override
	public Long save(BannerModel bannerModel) {
		StringBuilder sql = new StringBuilder("insert into banner (name, image, ");
		sql.append("info, createddate, createdby) values(?, ?, ");
		sql.append("?, ?, ?)");
		
		return insert(sql.toString(), bannerModel.getName() == null ? null : bannerModel.getName(), bannerModel.getImage() == null ? null : bannerModel.getImage(),
				bannerModel.getInfo() == null ? null : bannerModel.getInfo(),  bannerModel.getCreatedDate(), bannerModel.getCreatedBy());
	}

	@Override
	public void update(BannerModel updateBanner) {
		StringBuilder sql = new StringBuilder("update banner set name = ?, image = ?,");
		sql.append("info = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateBanner.getName(), updateBanner.getImage(),
				updateBanner.getInfo(), updateBanner.getCreatedDate() == null ? "null" : updateBanner.getCreatedDate(), 
				updateBanner.getCreatedBy() == null ? "null" : updateBanner.getCreatedBy(), updateBanner.getModifiedDate(),
				updateBanner.getModifiedBy(), updateBanner.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from banner where id = ?";
		
		update(sql, id);
		
	}

	@Override
	public List<BannerModel> find2Banner() {
		String sql = "SELECT * FROM banner ORDER BY id limit 0, 2";
		
		return query(sql, new BannerMapper());
	}

	@Override
	public List<BannerModel> find3Banner() {
		String sql = "SELECT * FROM banner ORDER BY id limit 2, 3";
		
		return query(sql, new BannerMapper());
	}

	@Override
	public List<BannerModel> findAllBanner() {
		String sql = "SELECT * FROM banner";
		
		return query(sql, new BannerMapper());
	}

	@Override
	public List<BannerModel> findAll(int index, int itemInPage) {
		String sql = "SELECT * FROM banner ORDER BY id limit ?, ?";
		
		return query(sql, new BannerMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from banner";
		
		return count(sql);
	}

}
