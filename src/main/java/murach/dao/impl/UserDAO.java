package murach.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import murach.dao.IUserDAO;
import murach.mapper.UserMapper;
import murach.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {

		StringBuilder sql = new StringBuilder("select * from users as u");

		sql.append(" inner join role as r on r.id = u.roleid");
		
		sql.append(" where username = ? and password = ? and status = ?");
		
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public UserModel findOneUserName(String username) {
		String sql = "select * from users where username = ?";
		
		List<UserModel> user = query(sql, new UserMapper(), username);
		
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("insert into users (username, password, email, ");
		sql.append("roleid, status, avatar, createddate, createdby, totalorders, totalprice) values(?, ?, ");
		sql.append("?, 2, 1, ?, ?, ?, 0, 0)");
		
		
		return insert(sql.toString(), userModel.getUserName() == null ? null : userModel.getUserName(),
				userModel.getPassword() == null ? null : userModel.getPassword(),
				userModel.getEmail() == null ? null : userModel.getEmail(),
				userModel.getAvatar() == null ? null : userModel.getAvatar(),
				userModel.getCreatedDate() == null ? null : userModel.getCreatedDate(),
				userModel.getCreatedBy() == null ? null : userModel.getCreatedBy());
	}

	@Override
	public void update(UserModel updateUser) {
		StringBuilder sql = new StringBuilder("update users set password = ?, email = ?,");
		sql.append("avatar = ?, phone = ?, address = ?, fullname = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateUser.getPassword() == null ? null : updateUser.getPassword(),
				updateUser.getEmail() == null ? null : updateUser.getEmail(),
				updateUser.getAvatar() == null ? null : updateUser.getAvatar(),
				updateUser.getPhone() == null ? null : updateUser.getPhone(),
				updateUser.getAddress() == null ? null : updateUser.getAddress(),
				updateUser.getFullName() == null ? null : updateUser.getFullName(),
				updateUser.getCreatedDate() == null ? null : updateUser.getCreatedDate(),
				updateUser.getCreatedBy() == null ? null : updateUser.getCreatedBy(),
				updateUser.getModifiedDate() == null ? null : updateUser.getModifiedDate(),
				updateUser.getModifiedBy() == null ? null : updateUser.getModifiedBy(),
				updateUser.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from users where id = ?";
		
		update(sql, id);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "select * from users where id = ?";
		
		List<UserModel> user = query(sql, new UserMapper(), id);
		
		return user.isEmpty() ? null : user.get(0);
	}


	@Override
	public void updateAddressAndPhone(String address, Long phone, Long id, Timestamp modifieddate, String modifiedby) {
		StringBuilder sql = new StringBuilder("update users set phone = ?, address = ?, ");
		sql.append("modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), phone, address, modifieddate, modifiedby, id);
		
	}

	@Override
	public List<UserModel> findAll(int index, int itemInPage) {
		String sql = "SELECT * FROM users where status = 1 and roleid = 2 ORDER BY fullname limit ?, ?";
		
		
		return query(sql, new UserMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from users where status = 1 and rodeid = 2";
		
		return count(sql);
	}

	@Override
	public void updateTotalOrders(Long id, Long totalorders) {
		StringBuilder sql = new StringBuilder("update users set totalorders = ? ");
		sql.append("where id = ?");
	
		update(sql.toString(), totalorders, id);
	}

	@Override
	public void updateTotalPrice(Long id, Long totalPrice) {
		StringBuilder sql = new StringBuilder("update users set totalprice = ? ");
		sql.append("where id = ?");
	
		update(sql.toString(), totalPrice, id);
	}

	@Override
	public List<UserModel> findTop10CustomerPrice() {
		String sql = "select * from users where roleid = 2 order by totalprice desc limit 0, 10";
		
		return query(sql, new UserMapper());
	}

	@Override
	public List<UserModel> findTop10CustomerOrders() {
		String sql = "select * from users where roleid = 2 order by totalorders desc limit 0, 10";
		
		return query(sql, new UserMapper());
	}

}
