package murach.service;

import murach.model.ContactModel;

public interface IContactService {

	ContactModel findOne(Long id);
	
	ContactModel update(ContactModel updateContact);
}
