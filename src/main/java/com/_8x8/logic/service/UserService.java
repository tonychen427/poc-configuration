package com._8x8.logic.service;

import java.util.List;
import com._8x8.data.repository.IUserRepository;
import com._8x8.presentation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository _userRepository;

    @Override
    public List<User> GetUsers() {
        return _userRepository.GetUsers();
    }

    @Override
    public User GetUserById(int Id) {
        return _userRepository.GetUserById(Id);
    }

    @Override
    public void UpdateUserById(User user) {
        _userRepository.UpdateUserById(user);
    }

    @Override
    public void RemoveUserById(int Id) {
       _userRepository.RemoveUserById(Id);
    }

    @Override
    public int InsertUser(User user) {
        return _userRepository.InsertUser(user);
    }
    
    @Override
    public boolean isUserExist(User user) {
      //return _usesrRepository.GetUserById(user.getId()).getUsername() == null;
        List<User> userList = _userRepository.GetUsers();
        for (User myUser : userList) {
            if(myUser.getUsername().equals(user.getUsername())){
              return true;  
            }
        }
        return false;
    }
}
