package murach.mapper;

import java.sql.ResultSet;

import murach.model.BannerModel;

public class BannerMapper implements RowMapper<BannerModel> {

	@Override
	public BannerModel mapRow(ResultSet resultSet) {
		try {
			BannerModel banner = new BannerModel();
			banner.setId(resultSet.getLong("id"));
			banner.setName(resultSet.getString("name"));
			banner.setImage(resultSet.getString("image"));
			banner.setInfo(resultSet.getString("info"));
			banner.setCreatedDate(resultSet.getTimestamp("createddate"));
			banner.setCreatedBy(resultSet.getString("createdby"));
			banner.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			banner.setModifiedBy(resultSet.getString("modifiedby"));
			
			
			return banner;
			
		}catch (Exception e) {
			return null;
		}
	}

}
