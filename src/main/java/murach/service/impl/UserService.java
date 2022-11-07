package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.IUserDAO;
import murach.model.UserModel;
import murach.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {

		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}


	@Override
	public UserModel findOneUserName(String username) {

		UserModel userModel = userDAO.findOneUserName(username);

		return userModel;
	}


	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		userModel.setAvatar("avatar_user.jpg");
		

		Long userId = userDAO.save(userModel);
		
		return userDAO.findOne(userId);
	}


	@Override
	public UserModel update(UserModel updateUser) {
		UserModel oldUser = userDAO.findOne(updateUser.getId());

		updateUser.setCreatedDate(oldUser.getCreatedDate());
		updateUser.setCreatedBy(oldUser.getCreatedBy());
		updateUser.setModifiedDate(new Timestamp(System.currentTimeMillis()));

		userDAO.update(updateUser);

		return userDAO.findOne(updateUser.getId());
	}


	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1. delete comment (khoa ngoai new_id)
			
			//2. delete news
			userDAO.delete(id);
		}
	}


	@Override
	public UserModel findOne(Long id) {
		UserModel userModel = userDAO.findOne(id);

		return userModel;
	}


	@Override
	public UserModel updateAddressAndPhone(String address, Long phone, Long id, Timestamp modifieddate,
			String modifiedby) {

		userDAO.updateAddressAndPhone(address, phone, id, modifieddate, modifiedby);;

		return userDAO.findOne(id);
	}


	@Override
	public List<UserModel> findAll(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return userDAO.findAll(index, itemInPage);
	}


	@Override
	public int getTotalItem() {
		return userDAO.getTotalItem();
	}


	@Override
	public UserModel updateTotalOrders(Long id, Long totalOrders) {
		userDAO.updateTotalOrders(id, totalOrders);
		
		return userDAO.findOne(id);
	}


	@Override
	public UserModel updateTotalPrice(Long id, Long totalPrice) {
		userDAO.updateTotalPrice(id, totalPrice);
		
		return userDAO.findOne(id);
	}


	@Override
	public List<UserModel> findTop10CustomerPrice() {
		return userDAO.findTop10CustomerPrice();
	}


	@Override
	public List<UserModel> findTop10CustomerOrders() {
		return userDAO.findTop10CustomerOrders();
	}


	
	
}
