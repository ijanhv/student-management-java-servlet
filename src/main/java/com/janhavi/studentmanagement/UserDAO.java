package com.janhavi.studentmanagement;

import java.util.List;

public interface UserDAO {
    void insertUser(User user);
    List<User> getAllUsers();
    void deleteUser(int userId);
    boolean checkIfUserExists(String email);
    boolean loginUser(String email, String password);
}