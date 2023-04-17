package eu.epfc.j6077.contactoo.domain;

public class ContactUseCase {
    private IContactUI ui;
    private IContactDao dao;

    public ContactUseCase(IContactUI ui, IContactDao dao) {
        this.ui = ui;
        this.dao = dao;
    }

    public void consultContact() {

    }

    public void addContact() {

    }

    public void updateContact() {

    }

    public void deleteContact() {

    }
}
