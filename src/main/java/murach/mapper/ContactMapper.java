package murach.mapper;

import java.sql.ResultSet;

import murach.model.ContactModel;

public class ContactMapper implements RowMapper<ContactModel> {

	@Override
	public ContactModel mapRow(ResultSet resultSet) {
		try {
			ContactModel contact = new ContactModel();
			contact.setId(resultSet.getLong("id"));
			contact.setName(resultSet.getString("name"));
			contact.setDetail(resultSet.getString("detail"));
			contact.setStatus(resultSet.getInt("status"));
			contact.setAddress(resultSet.getString("address"));
			contact.setPhone(resultSet.getLong("phone"));
			contact.setEmail(resultSet.getString("email"));
			contact.setCreatedDate(resultSet.getTimestamp("createddate"));
			contact.setCreatedBy(resultSet.getString("createdby"));
			contact.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			contact.setModifiedBy(resultSet.getString("modifiedby"));
			
			
			return contact;
			
		}catch (Exception e) {
			return null;
		}
	}

}
