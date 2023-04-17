package eu.epfc.j6077.contactoo;

import eu.epfc.j6077.contactoo.application.ApplicationFactory;

import java.util.Scanner;

public class Bootstrapper {
    public static void main(String[] args) {
        new ApplicationFactory()
                .createConsoleSql(new Scanner(System.in), System.out, "jdbc:h2:./contact")
                .run();
    }
}
