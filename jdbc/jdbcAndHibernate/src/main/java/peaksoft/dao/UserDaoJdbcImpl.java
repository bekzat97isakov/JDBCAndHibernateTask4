package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    Connection connection;
    public UserDaoJdbcImpl() {
        this.connection = Util.getConnection();
    }

    public String createUsersTable() {
        String create = """
                create table if not exists Users(
                id serial primary key,
                name varchar (50),
                lastName varchar (50),
                age smallint not null);
               """;
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute(create);
            System.out.println("Create table successfully");

        }catch (SQLException e){
            System.out.println("error");
        }

        return create;
    }

    public String dropUsersTable() {
        String drop = """
                drop table Users;
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(drop);
        }catch (SQLException e){
            System.out.println("no such table exists");
        }
        return drop;
    }

    public void saveUser(String name, String lastName, byte age) {
        String save = " insert into users(name, lastname, age) values (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(save)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.execute();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String query = """
                delete from users where id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String getUsers = "select * from Users";

        ArrayList<User> list = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(getUsers);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        String clean = "truncate table users";
        try (Connection connection = Util.getConnection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(clean);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}