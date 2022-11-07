package murach.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import murach.dao.IContactDAO;
import murach.model.ContactModel;
import murach.service.IContactService;

public class ContactService implements IContactService {
	
	@Inject
	private IContactDAO contactDao;

	@Override
	public ContactModel findOne(Long id) {
		ContactModel contactModel = contactDao.findOne(id);

		return contactModel;
	}

	@Override
	public ContactModel update(ContactModel updateContact) {
		ContactModel oldContact = contactDao.findOne(updateContact.getId());

		updateContact.setCreatedDate(oldContact.getCreatedDate());
		updateContact.setCreatedBy(oldContact.getCreatedBy());
		updateContact.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		

		contactDao.update(updateContact);

		return contactDao.findOne(updateContact.getId());
	}

}
