package murach.mapper;

import java.sql.ResultSet;

import murach.model.AboutModel;

public class AboutMapper implements RowMapper<AboutModel> {

	@Override
	public AboutModel mapRow(ResultSet resultSet) {
		try {
			AboutModel about = new AboutModel();
			about.setId(resultSet.getLong("id"));
			about.setName(resultSet.getString("name"));
			about.setDescription(resultSet.getString("description"));
			about.setDetail(resultSet.getString("detail"));
			about.setStatus(resultSet.getInt("status"));
			about.setImage(resultSet.getString("image"));
			about.setCreatedDate(resultSet.getTimestamp("createddate"));
			about.setCreatedBy(resultSet.getString("createdby"));
			about.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			about.setModifiedBy(resultSet.getString("modifiedby"));
			
			
			return about;
			
		}catch (Exception e) {
			return null;
		}
	}

}
