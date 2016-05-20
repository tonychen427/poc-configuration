package com._8x8.data.repository;

import com._8x8.presentation.model.User;
import java.util.List;

public interface IUserRepository {
    public List<User> GetUsers();
    public User GetUserById(int Id);
    public int InsertUser(User user);
    public void UpdateUserById(User user);
    public void RemoveUserById(int Id);
}
