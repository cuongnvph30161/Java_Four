package com.example.lab5;

import com.example.lab5.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://;serverName=103.124.94.100;databaseName=j4;encrypt=true;trustServerCertificate=true");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "abcd@1234");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(User.class);
        //conf.addAnnotatedClass(SanPham.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static EntityManager createEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void main(String[] args) {
        createEntityManager();
    }
}
