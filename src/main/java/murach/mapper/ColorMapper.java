package murach.mapper;

import java.sql.ResultSet;

import murach.model.ColoModel;

public class ColorMapper implements RowMapper<ColoModel> {

	@Override
	public ColoModel mapRow(ResultSet resultSet) {
		try {
			ColoModel color = new ColoModel();
			color.setId(resultSet.getLong("id"));
			color.setName(resultSet.getString("name"));
			color.setCode(resultSet.getString("code"));
			
			return color;
			
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
