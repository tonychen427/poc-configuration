/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.presentation.model.User;
import java.util.List;

/**
 *
 * @author Insprion
 */
public interface IUserService {

    public List<User> GetUsers();

    public User GetUserById(int Id);

    public int InsertUser(User user);

    public void UpdateUserById(User user);

    public void RemoveUserById(int Id);

    public boolean isUserExist(User user);
}
