package com.chiku.jdbc.demo;


import com.chiku.jdbc.entities.Instructor;
import com.chiku.jdbc.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // create objects
            Instructor instructor = new Instructor(
                    "chiku",
                    "banda",
                    "chiku@gmail.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "chiku's channel",
                    "codding"
            );

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // save instructor object
            session.save(instructor);

            // persist object
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
