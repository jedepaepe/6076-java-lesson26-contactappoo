package eu.epfc.j6077.contactoo.infrastructure.ui;

import eu.epfc.j6077.contactoo.domain.Contact;
import eu.epfc.j6077.contactoo.domain.IContactUI;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ContactConsoleUI implements IContactUI {
    private final Scanner input;
    private final PrintStream output;

    public ContactConsoleUI(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }


    @Override
    public void show(List<Contact> contacts) {
        for (Contact c : contacts) {
            output.println(String.join(" - ", "" + c.id, c.firstName, c.lastName, c.email, c.phone));
        }
    }

    @Override
    public Contact getWithoutId() {
        Contact contact = new Contact();
        getData(contact);
        return contact;
    }

    private void getData(Contact contact) {
        output.print("prénom: ");
        contact.firstName = input.nextLine();
        output.print("nom de famille: ");
        contact.lastName = input.nextLine();
        output.print("email: ");
        contact.email = input.nextLine();
        output.print("téléphone: ");
        contact.phone = input.nextLine();
    }

    @Override
    public Contact getWithId() {
        Contact contact = new Contact();
        contact.id = getId();
        getData(contact);
        return contact;
    }

    @Override
    public int getId() {
        output.print("identifiant: ");
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public String getChoose() {
        output.println("Votre choix:");
        output.println("(1) pour consulter la liste des contacts");
        output.println("(2) pour ajouter un contact");
        return null;
    }
}
