package murach.mapper;

import java.sql.ResultSet;

import murach.model.SlideModel;

public class SlideMapper implements RowMapper<SlideModel> {

	@Override
	public SlideModel mapRow(ResultSet resultSet) {
		try {
			SlideModel sile = new SlideModel();
			sile.setId(resultSet.getLong("id"));
			sile.setName(resultSet.getString("name"));
			sile.setImage(resultSet.getString("image"));
			sile.setSort(resultSet.getInt("sort"));
			sile.setLink(resultSet.getString("link"));
			sile.setStatus(resultSet.getInt("status"));
			sile.setInfo(resultSet.getString("info"));
			sile.setCreatedDate(resultSet.getTimestamp("createddate"));
			sile.setCreatedBy(resultSet.getString("createdby"));
			sile.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			sile.setModifiedBy(resultSet.getString("modifiedby"));
			
			
			return sile;
			
		}catch (Exception e) {
			return null;
		}
	}

}
