package murach.dao.impl;

import java.util.List;

import murach.dao.ISlieDAO;
import murach.mapper.SlideMapper;
import murach.model.SlideModel;

public class SlideDAO extends AbstractDAO<SlideModel> implements ISlieDAO {

	@Override
	public SlideModel findOne(Long id) {
		String sql = "select * from slide where id = ?";
		
		List<SlideModel> slide = query(sql, new SlideMapper(), id);
		
		return slide.isEmpty() ? null : slide.get(0);
	}

	@Override
	public Long save(SlideModel slideModel) {
		StringBuilder sql = new StringBuilder("insert into slide (name, image, ");
		sql.append("info, status, createddate, createdby) values(?, ?, ");
		sql.append("?, 1, ?, ?)");
		
		return insert(sql.toString(), slideModel.getName() == null ? null : slideModel.getName(), slideModel.getImage() == null ? null : slideModel.getImage(),
				slideModel.getInfo() == null ? null : slideModel.getInfo(),  slideModel.getCreatedDate(), slideModel.getCreatedBy());
	}

	@Override
	public void update(SlideModel updateSlide) {
		StringBuilder sql = new StringBuilder("update slide set name = ?, image = ?,");
		sql.append("info = ?, status = 1, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateSlide.getName(), updateSlide.getImage(),
				updateSlide.getInfo(), updateSlide.getCreatedDate() == null ? "null" : updateSlide.getCreatedDate(), 
				updateSlide.getCreatedBy() == null ? "null" : updateSlide.getCreatedBy(), updateSlide.getModifiedDate(),
				updateSlide.getModifiedBy(), updateSlide.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from slide where id = ?";
		
		update(sql, id);
		
	}

	@Override
	public List<SlideModel> findAll(int index, int itemInPage) {
		String sql = "SELECT * FROM slide ORDER BY id limit ?, ?";
		
		return query(sql, new SlideMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from slide";
		
		return count(sql);
	}

	@Override
	public List<SlideModel> findAllSlide() {
		String sql = "SELECT * FROM slide ORDER BY id asc";
		
		return query(sql, new SlideMapper());
	}

}
