package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.ContactDAO;
import com.myapp.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional    
	public Contact getContactById(Integer Id) {
		return contactDAO.getContactById(Id);
	}
	
    
    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }
    @Override
    @Transactional
    public List<Contact> listContact() {
 
        return contactDAO.listContact();
    }
    @Override
    @Transactional
    public void removeContact(Integer cId) {
        contactDAO.removeContact(cId);
    }

}
