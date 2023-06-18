package com.example.tovar;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import tables.*;

import java.util.List;
import java.util.Scanner;


public class Hibernate {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public Hibernate() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<TovarEntity> getLeatherShoes(String material, int footSize) {
        TypedQuery<TovarEntity> query = entityManager.createQuery(
                "SELECT te " +
                        "FROM TovarEntity te " +
                        "JOIN ShoesEntity se ON te.id = se.idTovar " +
                        "WHERE se.material = :material " +
                        "AND se.footSize = :footSize " +
                        "AND te.buying = 'обувь'", TovarEntity.class);
        query.setParameter("material", material);
        query.setParameter("footSize", footSize);
        return query.getResultList();
    }


    public List<DriversEntity> getDriversByQuantityAndWeight(String quantity, int weight) {
        TypedQuery<DriversEntity> query = entityManager.createQuery(
                "SELECT de " +
                        "FROM DriversEntity de " +
                        "JOIN BuyingEntity be ON de.idBuying = be.id " +
                        "JOIN TovarEntity te ON be.id = te.idBuying " +
                        "WHERE te.quanity = :quantity " +
                        "AND be.weight = :weight", DriversEntity.class);
        query.setParameter("quantity", quantity);
        query.setParameter("weight", weight);
        return query.getResultList();
    }

    public List<CarsEntity> getCarsWithQuantity(String quantity) {
        TypedQuery<CarsEntity> query = entityManager.createQuery(
                "SELECT ce " +
                        "FROM CarsEntity ce " +
                        "JOIN TovarEntity te ON ce.idBuying = te.idBuying " +
                        "WHERE te.quanity = :quantity", CarsEntity.class);
        query.setParameter("quantity", quantity);
        return query.getResultList();
    }
    public void run() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            // Создание запроса для выборки джинсов с весом 900 грамм
            TypedQuery<JeansEntity> query = entityManager.createQuery(
                    "SELECT j FROM JeansEntity j " +
                            "JOIN TovarEntity t ON j.idTovar = t.id " +
                            "JOIN BuyingEntity b ON t.idBuying = b.id " +
                            "WHERE b.weight = :weight", JeansEntity.class);
            query.setParameter("weight", 900);


            List<JeansEntity> jeansList = query.getResultList();


            for (JeansEntity jeans : jeansList) {
                System.out.println("ID: " + jeans.getId());
                System.out.println("Strength: " + jeans.getStrenght());
                System.out.println("Size: " + jeans.getSize());
                System.out.println("Tovar ID: " + jeans.getIdTovar());
                System.out.println("----------------------");
            }


            entityManager.getTransaction().commit();
        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {

            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public List<UserDataEntity> getUsersWithYoungDriver(int age) {
        TypedQuery<UserDataEntity> query = entityManager.createQuery(
                "SELECT ud " +
                        "FROM UserDataEntity ud " +
                        "JOIN DriversEntity dr ON ud.idDrivers = dr.id " +
                        "WHERE dr.age <= 40", UserDataEntity.class);
        return query.getResultList();
    }
    public void updateTovarQuantity(int tovarId, int newQuantity) {
        entityManager.getTransaction().begin();

        TovarEntity tovar = entityManager.find(TovarEntity.class, tovarId);
        if (tovar != null) {
            tovar.setQuanity(newQuantity);
            entityManager.merge(tovar);
        }

        entityManager.getTransaction().commit();
    }


    public void addShoesWithBoxWeight(int boxWeight) { //добавление
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ShoesEntity shoes = new ShoesEntity();
            shoes.setMaterial("material_value");
            shoes.setFootSize(42);
            shoes.setViewe("viewe_value");
            shoes.setBrand("brand_value");
            shoes.setQuanity(1);

            BuyingEntity buying = new BuyingEntity();
            buying.setWeight(boxWeight);

            TovarEntity tovar = new TovarEntity();
            tovar.setBuying("обувь");
            tovar.setQuanity(1);

            shoes.setIdTovar(tovar.getId());
            tovar.setIdBuying(buying.getId());

            entityManager.persist(buying);
            entityManager.persist(tovar);
            entityManager.persist(shoes);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public static void deleteShoesWithQuantityLessThan(EntityManager entityManager, int number) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<ShoesEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(ShoesEntity.class);
        Root<ShoesEntity> root = criteriaDelete.from(ShoesEntity.class);

        criteriaDelete.where(criteriaBuilder.lessThan(root.get("quanity"), number));

        entityManager.getTransaction().begin();
        entityManager.createQuery(criteriaDelete).executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void addNewHeaddress() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сезон: ");
        String season = scanner.nextLine();

        System.out.print("Введите формы: ");
        String forms = scanner.nextLine();

        System.out.print("Введите ID товара: ");
        int idTovar = scanner.nextInt();

        HeaddressEntity headdress = new HeaddressEntity();
        headdress.setSeason(season);
        headdress.setForms(forms);
        headdress.setIdTovar(idTovar);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(headdress);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
    public Integer getQuantityById(int id) {
        TypedQuery<TovarEntity> query = entityManager.createQuery(
                "SELECT te FROM TovarEntity te WHERE te.id = :id", TovarEntity.class);
        query.setParameter("id", id);
        TovarEntity tovar = query.getSingleResult();
        return tovar.getQuanity();
    }

    public void updateQuantityById(int id, int newQuantity) {
        entityManager.getTransaction().begin();
        TovarEntity tovar = entityManager.find(TovarEntity.class, id);
        tovar.setQuanity(newQuantity);
        entityManager.getTransaction().commit();
    }

    public List<CarsEntity> getCarsWithBuyingColor(String color) {
        TypedQuery<CarsEntity> query = entityManager.createQuery(
                "SELECT ce " +
                        "FROM CarsEntity ce " +
                        "JOIN BuyingEntity be ON ce.idBuying = be.id " +
                        "WHERE be.color = :color", CarsEntity.class);
        query.setParameter("color", color);
        return query.getResultList();
    }


    public List<BuyingEntity> getBuyingsByColor(String color) {
        TypedQuery<BuyingEntity> query = entityManager.createQuery(
                "SELECT b " +
                        "FROM BuyingEntity b " +
                        "WHERE b.color = :color", BuyingEntity.class);
        query.setParameter("color", color);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

