package murach.dao;

import java.sql.Timestamp;
import java.util.List;

import murach.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

	UserModel findOneUserName(String username);
	
	Long save(UserModel userModel);
	
	void update(UserModel updateUser);
	
	void delete(long id);
	
	UserModel findOne(Long id);
	
	void updateAddressAndPhone(String address, Long phone, Long id, Timestamp modifieddate, String modifiedby);
	

	List<UserModel> findAll(int index, int itemInPage);
	
	int getTotalItem();
	
	void updateTotalOrders(Long id, Long totalOrders);
	
	void updateTotalPrice(Long id, Long totalPrice);
	
	List<UserModel> findTop10CustomerPrice();
	
	List<UserModel> findTop10CustomerOrders();
	
}
