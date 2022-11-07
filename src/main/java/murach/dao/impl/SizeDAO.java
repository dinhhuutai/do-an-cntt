package murach.dao.impl;

import java.util.List;

import murach.dao.ISizeDAO;
import murach.mapper.SizeMapper;
import murach.model.SizeModel;

public class SizeDAO extends AbstractDAO<SizeModel> implements ISizeDAO {

	@Override
	public List<SizeModel> findAll() {

		String sql = "select * from size";
		
		return query(sql, new SizeMapper());
	}

	@Override
	public SizeModel findOne(long id) {
		String sql = "select * from color where id = ?";

		List<SizeModel> size = query(sql, new SizeMapper(), id);
		
		return size.isEmpty() ? null : size.get(0);
	}


	

}
