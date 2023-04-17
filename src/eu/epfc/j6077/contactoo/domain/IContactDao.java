package eu.epfc.j6077.contactoo.domain;

import eu.epfc.j6077.contactoo.domain.Contact;

import java.util.List;

public interface IContactDao {
    void insert(Contact contact);
    List<Contact> select();
    void update(Contact contact);
    void delete(int id);
}
