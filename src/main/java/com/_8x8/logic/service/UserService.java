package com._8x8.logic.service;

import java.util.List;
import com._8x8.data.repository.IUserRepository;
import com._8x8.presentation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository _usesrRepository;

    @Override
    public List<User> GetUsers() {
        return _usesrRepository.GetUsers();
    }

    @Override
    public User GetUserById(int Id) {
        return _usesrRepository.GetUserById(Id);
    }

    @Override
    public void UpdateUserById(User user) {
        _usesrRepository.UpdateUserById(user);
    }

    @Override
    public void RemoveUserById(int Id) {
       _usesrRepository.RemoveUserById(Id);
    }

    @Override
    public int InsertUser(User user) {
        return _usesrRepository.InsertUser(user);
    }
    
    @Override
    public boolean isUserExist(User user) {
      //return _usesrRepository.GetUserById(user.getId()).getUsername() == null;
        return _usesrRepository.GetUserById(user.getId()) == null;
    }
}
