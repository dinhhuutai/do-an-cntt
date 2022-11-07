package murach.dao;

import java.util.List;

import murach.model.SizeModel;


public interface ISizeDAO extends GenericDAO<SizeModel> {

	List<SizeModel> findAll();

	SizeModel findOne(long id);
}
