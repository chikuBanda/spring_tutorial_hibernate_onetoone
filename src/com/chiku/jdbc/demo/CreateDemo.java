package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Instructor;
import com.chiku.jdbc.entities.InstructorDetail;
import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure()
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        try {
            /*// create instructor object
            Instructor instructor = new Instructor("chiku", "banda", "chikubanda.cb@gmail.com");

            // create instructor detail
            InstructorDetail instructorDetail = new InstructorDetail("youtuve.com", "coding");

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // begin transaction
            session.beginTransaction();

            // save the instructor
            // this will also save the instructor details
            // because of cascade.ALL
            System.out.println("Saving instructor" + instructor);
            session.save(instructor);*/

            /*********************************************/

            // begin transaction
            session.beginTransaction();

            // retrieve instructor
            Instructor myInstructor = session.get(Instructor.class, 1);

            System.out.println(myInstructor);

            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
