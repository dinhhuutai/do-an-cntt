package murach.dao.impl;

import java.util.List;

import murach.dao.IContactDAO;
import murach.mapper.ContactMapper;
import murach.model.ContactModel;

public class ContactDAO extends AbstractDAO<ContactModel> implements IContactDAO {

	@Override
	public ContactModel findOne(Long id) {
		String sql = "select * from contact where id = ?";
		
		List<ContactModel> contact = query(sql, new ContactMapper(), id);
		
		return contact.isEmpty() ? null : contact.get(0);
	}

	@Override
	public void update(ContactModel updateContact) {
		StringBuilder sql = new StringBuilder("update contact set name = ?, address = ?,");
		sql.append("phone = ?, email = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateContact.getName(), updateContact.getAddress(), updateContact.getPhone(),
				updateContact.getEmail(), updateContact.getCreatedDate() == null ? "null" : updateContact.getCreatedDate(), 
				updateContact.getCreatedBy() == null ? "null" : updateContact.getCreatedBy(), updateContact.getModifiedDate(),
				updateContact.getModifiedBy(), updateContact.getId());
		
	}

}
