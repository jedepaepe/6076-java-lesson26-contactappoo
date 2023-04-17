package eu.epfc.j6077.contactoo.domain;

import java.util.List;

public interface IContactUI {
    void show(List<Contact> contacts);
    Contact getWithoutId();
    Contact getWithId();
    int getId();
    String getChoose();
}
