package eu.epfc.j6077.contactoo.infrastructure.database;

import eu.epfc.j6077.contactoo.domain.Contact;
import eu.epfc.j6077.contactoo.domain.IContactDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactSqlDao implements IContactDao {
    private final String connectionString;

    public ContactSqlDao(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void insert(Contact contact) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "insert into CONTACT (FIRSTNAME, LASTNAME, EMAIL, PHONE) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contact.firstName);
            preparedStatement.setString(2, contact.lastName);
            preparedStatement.setString(3, contact.email);
            preparedStatement.setString(4, contact.phone);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> select() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "select ID, FIRSTNAME, LASTNAME, EMAIL, PHONE from CONTACT";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.id = resultSet.getInt("ID");
                contact.firstName = resultSet.getString("FIRSTNAME");
                contact.lastName = resultSet.getString("LASTNAME");
                contact.email = resultSet.getString("EMAIL");
                contact.phone = resultSet.getString("PHONE");
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(int id) {

    }
}
