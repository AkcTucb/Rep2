package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // 1. Создание таблицы пользователей
        userService.createUsersTable();

        // 2. Добавляем 4 User(ов) и выводим сообщение
        userService.saveUser("Ivan", "Ivanov", (byte) 5);
        System.out.println("User с именем – Ivan добавлен в базу данных");
        userService.saveUser("Petr", "Petrov", (byte) 15);
        System.out.println("User с именем – Petr добавлен в базу данных");
        userService.saveUser("Svetlana", "Sidorova", (byte) 25);
        System.out.println("User с именем – Svetlana добавлен в базу данных");
        userService.saveUser("Anna", "Smirnova", (byte) 35);
        System.out.println("User с именем – Anna добавлен в базу данных");

        // 3. Получаем всех пользователей из БД и выводим в консоль
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // 4. Очищаем таблицу
        userService.cleanUsersTable();

        // 5. Удаляем таблицу
        userService.dropUsersTable();
    }
}
