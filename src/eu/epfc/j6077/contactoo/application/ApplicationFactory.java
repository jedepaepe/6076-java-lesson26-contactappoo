package eu.epfc.j6077.contactoo.application;

import eu.epfc.j6077.contactoo.domain.ContactUseCase;
import eu.epfc.j6077.contactoo.domain.IContactUI;
import eu.epfc.j6077.contactoo.infrastructure.database.ContactSqlDao;
import eu.epfc.j6077.contactoo.domain.IContactDao;
import eu.epfc.j6077.contactoo.infrastructure.ui.ContactConsoleUI;

import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationFactory {
    public Application createConsoleSql(Scanner scanner, PrintStream out, String connectionString) {
        IContactUI ui = new ContactConsoleUI(scanner, out);
        IContactDao dao = new ContactSqlDao(connectionString);
        ContactUseCase useCase = new ContactUseCase(ui, dao);
        return new Application(useCase);
    }
}
