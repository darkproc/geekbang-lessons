package org.geektimes.projects.user.repository;

import org.geektimes.projects.user.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;

public class MyUserRepository implements UserRepository {
    public static final String INSERT_USER_DML_SQL =
            "INSERT INTO users(name,password,email,phoneNumber) VALUES " +
                    "(?,?,?,?)";
    @Override
    public boolean save(User user) {
        try {
            System.out.println("========exec:MyUserRepository.save success ========");
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
            return  false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
