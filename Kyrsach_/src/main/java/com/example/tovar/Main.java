package com.example.tovar;

import jakarta.persistence.*;
import org.hibernate.Session;
import tables.*;

import java.util.List;

import java.util.Scanner;

public class Main {
    private static List<BuyingEntity> BuyingsByColor;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hibernate hibernateCode = new Hibernate();
        boolean exit = false;


        while (!exit) {
            System.out.println("Выбрать запрос:");
            System.out.println("1: Получить список товара = обувь");
            System.out.println("2: Получить список водителей исходя из количества товара ");
            System.out.println("3: Получить список покупок определенного цвета +вывод веса покупки");
            System.out.println("4: Получить список пользователей доставившим покупку водитель с возрастом не больше = “40 лет");
            System.out.println("5: Изменить количество товаров с определенным id");
            System.out.println("6: Получить список по определенному цвету покупки, вывести машину доставщика");
            System.out.println("7: Удалить обувь с определенным количеством < какого-либо числа");
            System.out.println("8: Добавить новый головной убор");
            System.out.println("0: Выход");
            System.out.print("Наш выбор: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;

                case 1:
                    Hibernate hibernate = new Hibernate();

                    scanner = new Scanner(System.in);

                    System.out.print("Введите материал: ");
                    String material = scanner.nextLine();

                    System.out.print("Введите размер ноги: ");
                    int footSize = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера сканера


                    List<TovarEntity> leatherShoes = hibernate.getLeatherShoes(material, footSize);


                    for (TovarEntity tovar : leatherShoes) {
                        System.out.println("ID: " + tovar.getId());
                        System.out.println("Buying: " + tovar.getBuying());
                        System.out.println("Quantity: " + tovar.getQuanity());
                        System.out.println("ID Buying: " + tovar.getIdBuying());
                    }

                    break;

                case 2:


                    Hibernate hibernateQueryExecutor = new Hibernate();

                    scanner = new Scanner(System.in);

                    System.out.print("Введите количество: ");
                    String quantity = scanner.nextLine();

                    System.out.print("Введите вес: ");
                    int weight = scanner.nextInt();
                    scanner.nextLine();


                    List<DriversEntity> drivers = hibernateQueryExecutor.getDriversByQuantityAndWeight(quantity, weight);


                    for (DriversEntity driver : drivers) {
                        System.out.println("ID: " + driver.getId());
                        System.out.println("Name: " + driver.getName());
                        System.out.println("Age: " + driver.getAge());
                        System.out.println("ID Buying: " + driver.getIdBuying());
                    }

                    hibernateQueryExecutor.close();

                    break;


                case 3:
                    EntityManager entityManager3 = Persistence.createEntityManagerFactory("persistence")
                            .createEntityManager();
                    scanner = new Scanner(System.in);
                    System.out.print("Введите цвет: ");
                    String color_2 = scanner.nextLine();

                    TypedQuery<BuyingEntity> query = entityManager3.createQuery(
                            "SELECT b " +
                                    "FROM BuyingEntity b " +
                                    "WHERE b.color = :color", BuyingEntity.class);
                    query.setParameter("color", color_2);

                    List<BuyingEntity> buyings = query.getResultList();
                    for (BuyingEntity buying : buyings) {
                        System.out.println("Покупка ID: " + buying.getId());
                        System.out.println("Цвет: " + buying.getColor());
                        System.out.println("Вес: " + buying.getWeight());

                    }

                    break;


                case 4:
                    Hibernate hibernate_4 = new Hibernate();

                    scanner = new Scanner(System.in);

                    System.out.print("Введите возраст водителя: ");
                    int age = scanner.nextInt();


                    List<UserDataEntity> users = hibernate_4.getUsersWithYoungDriver(age);


                    for (UserDataEntity user : users) {
                        System.out.println("ID: " + user.getId());
                        System.out.println("Name: " + user.getName());
                        System.out.println("Surname: " + user.getSurname());
                        System.out.println("Name of Buying: " + user.getNameOfBuying());
                        System.out.println("Track Number: " + user.getTrackNumber());
                        System.out.println("ID Buying: " + user.getIdBuying());
                        System.out.println("ID Drivers: " + user.getIdDrivers());
                    }

                    hibernate_4.close();

                    break;

                case 5:


                    Hibernate hibernate_5 = new Hibernate();

                    scanner = new Scanner(System.in);
                    System.out.print("Введите идентификатор товара: ");
                    int id = scanner.nextInt();

                    Integer quantity_1 = hibernate_5.getQuantityById(id);
                    System.out.println("Текущее количество товара с идентификатором " + id + ": " + quantity_1);

                    System.out.print("Введите новое количество товара: ");
                    int newQuantity = scanner.nextInt();

                    hibernate_5.updateQuantityById(id, newQuantity);
                    System.out.println("Количество товара успешно изменено.");

                    hibernate_5.close();

                    break;
                case 6:
                    Hibernate hibernate_6 = new Hibernate();

                    scanner = new Scanner(System.in);
                    System.out.print("Введите цвет покупки: ");
                    String color = scanner.nextLine();

                    List<CarsEntity> carsWithColor = hibernate_6.getCarsWithBuyingColor(color);
                    System.out.println("Список машин с покупкой цвета " + color + ":");

                    for (CarsEntity car : carsWithColor) {
                        System.out.println("ID: " + car.getId());
                        System.out.println("Type: " + car.getType());
                        System.out.println("View Trailer: " + car.getViewTrailer());
                        System.out.println("ID Buying: " + car.getIdBuying());
                        System.out.println();
                    }

                    hibernate_6.close();

                    break;

                case 7:


                    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
                    EntityManager entityManager = entityManagerFactory.createEntityManager();

                    scanner = new Scanner(System.in);
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();

                    Hibernate.deleteShoesWithQuantityLessThan(entityManager, number);

                    entityManager.close();
                    entityManagerFactory.close();

                    break;

                case 8:

                    Hibernate hibernate_8 = new Hibernate();
                    hibernateCode.addNewHeaddress();
            }
        }
    }
}