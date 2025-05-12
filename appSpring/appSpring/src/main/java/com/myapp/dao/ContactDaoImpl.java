package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Contact;


@Repository
public class ContactDaoImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Contact getContactById(Integer Id) {
		return (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, Id);
	}
	
	@Override
	public void addContact(Contact contact) {
		this.sessionFactory.getCurrentSession().save(contact);
	}
        @Override
	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contacts")
				.list();
	}
        @Override
	public void removeContact(Integer cId) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, cId);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
}
