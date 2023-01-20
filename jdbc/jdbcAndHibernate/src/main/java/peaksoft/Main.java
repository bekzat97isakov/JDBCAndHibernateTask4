package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
       System.out.println(userService.createUsersTable());
        //System.out.println(userService.dropUsersTable());
        //System.out.println(userService.saveUser("Bekzat","Isakov",(byte) 25));
       // System.out.println(userService.saveUser("Asan","Asanov",(byte) 20));
        //userService.removeUserById(1L);
        //System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
    }
}
