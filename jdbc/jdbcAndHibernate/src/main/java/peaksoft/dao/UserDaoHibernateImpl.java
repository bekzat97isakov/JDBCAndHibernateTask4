package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public String createUsersTable() {

        return null;
    }

    @Override
    public String dropUsersTable() {

        return null;
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
