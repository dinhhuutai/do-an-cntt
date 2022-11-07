package murach.dao.impl;

import java.util.List;

import murach.dao.IColorDAO;
import murach.mapper.ColorMapper;
import murach.model.ColoModel;

public class ColorDAO extends AbstractDAO<ColoModel> implements IColorDAO {

	@Override
	public List<ColoModel> findAll() {

		String sql = "select * from color";
		
		return query(sql, new ColorMapper());
	}

	@Override
	public ColoModel findOne(long id) {
		String sql = "select * from color where id = ?";

		List<ColoModel> color = query(sql, new ColorMapper(), id);
		
		return color.isEmpty() ? null : color.get(0);
	}

	@Override
	public ColoModel findOneByCode(String code) {
		String sql = "select * from color where code = ?";

		List<ColoModel> color = query(sql, new ColorMapper(), code);
		
		return color.isEmpty() ? null : color.get(0);
	}


	

}
