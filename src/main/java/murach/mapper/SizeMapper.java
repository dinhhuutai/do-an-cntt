package murach.mapper;

import java.sql.ResultSet;

import murach.model.SizeModel;

public class SizeMapper implements RowMapper<SizeModel> {

	@Override
	public SizeModel mapRow(ResultSet resultSet) {
		try {
			SizeModel size = new SizeModel();
			size.setId(resultSet.getLong("id"));
			size.setName(resultSet.getString("name"));
			size.setCode(resultSet.getString("code"));
			
			return size;
			
		}catch (Exception e) {
			return null;
		}
	}

}
