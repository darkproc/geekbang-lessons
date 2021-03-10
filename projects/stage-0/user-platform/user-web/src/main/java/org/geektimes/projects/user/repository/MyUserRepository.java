package org.geektimes.projects.user.repository;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;

public class MyUserRepository implements UserRepository {
    @Resource(name= "bean/DBConnectionManager")
    private DBConnectionManager dbConnectionManager;

    @Resource(name = "bean/EntityManager")
    private EntityManager entityManager;
    public static final String INSERT_USER_DML_SQL =
            "INSERT INTO users(name,password,email,phoneNumber) VALUES " +
                    "(?,?,?,?)";
    public boolean save(User user) {
        return false;
    }
    @Override
    public String saveWithReStr(User user) {
        String reStr="success";
        try {
            System.out.println("========exec:MyUserRepository.save  ========");
            //version 1.0
//            String databaseURL = "jdbc:derby:D:/db/user-platform;create=true";
////            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection connection = DriverManager.getConnection(databaseURL);
//            PreparedStatement statement= connection.prepareStatement(INSERT_USER_DML_SQL);
//            statement.setString(1,user.getName());
//            statement.setString(2,user.getPassword());
//            statement.setString(3,user.getEmail());
//            statement.setString(4,user.getPhoneNumber());
//            int i = statement.executeUpdate();
//            if(i > 0){
//                return true;
//            }

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            user.setId(null);//擦除掉id，否则持久化时会抛异常
            entityManager.persist(user);
            transaction.commit();
//            Connection connection = dbConnectionManager.getConnection();
//            entityManager.persist(user);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            reStr = e.getMessage();
        }
        return reStr;
    }

    @Override
    public boolean deleteById(Long userId) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User getById(Long userId) {
        return null;
    }

    @Override
    public User getByNameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }
}
