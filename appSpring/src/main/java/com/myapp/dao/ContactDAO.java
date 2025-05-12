package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Contact;

public interface ContactDAO {

	public Contact getContactById(Integer Id);
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer cId);
}
