package murach.dao;

import murach.model.ContactModel;

public interface IContactDAO extends GenericDAO<ContactModel> {

	ContactModel findOne(Long id);
	
	void update(ContactModel updateContact);
}
