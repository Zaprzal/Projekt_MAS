package AppClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFac {
    private static SessionFactory sessionFactory;

    private static Session session;

    public static Session openSession (){
        if(session == null)
            session = SessionFac.getSessionFactory().openSession();
        return session;
    }

    private static SessionFactory getSessionFactory() {
        if(sessionFactory != null) {
            return sessionFactory;
        }
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        sessionFactory = factory;
        return factory;
    }
}
