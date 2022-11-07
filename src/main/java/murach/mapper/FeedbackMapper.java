package murach.mapper;

import java.sql.ResultSet;

import murach.model.FeedbackModel;

public class FeedbackMapper implements RowMapper<FeedbackModel> {

	@Override
	public FeedbackModel mapRow(ResultSet resultSet) {
		try {
			FeedbackModel feedback = new FeedbackModel();
			feedback.setId(resultSet.getLong("id"));
			feedback.setName(resultSet.getString("name"));
			feedback.setEmail(resultSet.getString("email"));
			feedback.setPhone(resultSet.getLong("phone"));
			feedback.setAddress(resultSet.getString("address"));
			feedback.setDetail(resultSet.getString("detail"));
			
			
			return feedback;
			
		}catch (Exception e) {
			return null;
		}
	}

}
