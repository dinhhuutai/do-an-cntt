package murach.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import murach.model.RoleModel;
import murach.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
	
		try {
			
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setAddress(resultSet.getString("address"));
			user.setEmail(resultSet.getString("email"));
			user.setPhone(resultSet.getLong("phone"));
			user.setAvatar(resultSet.getString("avatar"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			user.setCreatedBy(resultSet.getString("createdby"));
			user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			user.setModifiedBy(resultSet.getString("modifiedby"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setTotalPrice(resultSet.getLong("totalprice"));
			user.setTotalOrders(resultSet.getLong("totalorders"));
			
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				
				user.setRole(role);
				
			} catch (Exception e) {
				
			}
			
			return user;
			
		} catch (SQLException e) {
			
			return null;
		}
	}

}
