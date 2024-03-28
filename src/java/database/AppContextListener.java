package database;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Tu tworzysz i dodajesz domyślnego użytkownika
        User defaultUser = new User("ola", "oli");

        // Dodanie użytkownika do uproszczonej bazy danych
        UserDatabase.addUser(defaultUser);

        System.out.println("Domyślny użytkownik został dodany.!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Tutaj można zwolnić zasoby, jeśli jest taka potrzeba
    }
}
