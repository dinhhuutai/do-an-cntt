package murach.service;

import java.sql.Timestamp;
import java.util.List;

import murach.model.UserModel;

public interface IUserService {
	
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	

	UserModel findOneUserName(String username);
	
	UserModel save(UserModel userModel);
	
	UserModel update(UserModel updateUser);
	
	void delete(long[] ids);

	UserModel findOne(Long id);
	
	UserModel updateAddressAndPhone(String address, Long phone, Long id, Timestamp modifieddate, String modifiedby);
	

	List<UserModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	UserModel updateTotalOrders(Long id, Long totalOrders);
	
	UserModel updateTotalPrice(Long id, Long totalPrice);

	List<UserModel> findTop10CustomerPrice();
	
	List<UserModel> findTop10CustomerOrders();
}
