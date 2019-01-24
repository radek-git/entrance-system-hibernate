package com.radek.entranceSystem;

import com.radek.entranceSystem.hibernate.Box;
import com.radek.entranceSystem.hibernate.BoxHistory;
import com.radek.entranceSystem.hibernate.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {

    public static Database instance;
    public static SessionFactory sessionFactory;
    public static Session session;

    private Database() {
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        try {
            var metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void test() {
        session = sessionFactory.openSession();

        session.getTransaction().begin();


        var user = session.get(User.class, 1);
        System.out.println(user.getSurname());

        var box = session.get(Box.class, 1);
        System.out.println(box.getId());

        var boxHistory = new BoxHistory(box, user, "Close");

        session.save(boxHistory);







        session.getTransaction().commit();

        session.close();
    }
}
