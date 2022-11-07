package murach.dao.impl;

import java.util.List;

import murach.dao.IAboutDAO;
import murach.mapper.AboutMapper;
import murach.model.AboutModel;

public class AboutDAO extends AbstractDAO<AboutModel> implements IAboutDAO {

	@Override
	public AboutModel findOne(Long id) {
		String sql = "select * from about where id = ?";
		
		List<AboutModel> about = query(sql, new AboutMapper(), id);
		
		return about.isEmpty() ? null : about.get(0);
	}

	@Override
	public Long save(AboutModel aboutModel) {
		StringBuilder sql = new StringBuilder("insert into about (name, image, ");
		sql.append("description, createddate, createdby) values(?, ?, ");
		sql.append("?, ?, ?)");
		
		return insert(sql.toString(), aboutModel.getName() == null ? null : aboutModel.getName(), aboutModel.getImage() == null ? null : aboutModel.getImage(),
				aboutModel.getDescription() == null ? null : aboutModel.getDescription(),  aboutModel.getCreatedDate(), aboutModel.getCreatedBy());
	}

	@Override
	public void update(AboutModel updateAbout) {
		
		StringBuilder sql = new StringBuilder("update about set name = ?, image = ?,");
		sql.append("description = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateAbout.getName(), updateAbout.getImage(),
				updateAbout.getDescription(), updateAbout.getCreatedDate() == null ? "null" : updateAbout.getCreatedDate(), 
				updateAbout.getCreatedBy() == null ? "null" : updateAbout.getCreatedBy(), updateAbout.getModifiedDate(),
				updateAbout.getModifiedBy(), updateAbout.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from about where id = ?";
		
		update(sql, id);
	}

	@Override
	public List<AboutModel> findAll(int index, int itemInPage) {
		String sql = "SELECT * FROM about ORDER BY id limit ?, ?";
		
		return query(sql, new AboutMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from about";
		
		return count(sql);
	}

	@Override
	public List<AboutModel> findAllAbout() {
		String sql = "SELECT * FROM about ORDER BY id asc";
		
		return query(sql, new AboutMapper());
	}

}
