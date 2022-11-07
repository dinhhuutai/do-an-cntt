package murach.dao;

import java.util.List;

import murach.model.ColoModel;


public interface IColorDAO extends GenericDAO<ColoModel> {

	List<ColoModel> findAll();

	ColoModel findOne(long id);

	ColoModel findOneByCode(String code);
}
