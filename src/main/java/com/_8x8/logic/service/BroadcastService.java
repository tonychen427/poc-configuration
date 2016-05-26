/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.data.repository.IBroadcastRepository;
import com._8x8.data.repository.IUserRepository;
import com._8x8.presentation.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BroadcastService implements IBroadcastService{

    @Autowired 
    IUserRepository _userRepository;
    
    @Autowired
    IBroadcastRepository _broadcastRepository;
    
    @Override
    public Boolean SendBroadcastMsg(String Msg, String QRCode) {
        List<User> UserList = _userRepository.GetUsers();
        for (User user : UserList) {
            if (user.getQrcode() == null ? QRCode == null : user.getQrcode().equals(QRCode)) {
                //String RegisterId = "djO6PMXp0rY:APA91bH3SUSaq68U9ne1LAWxTEcRYmIlHdiiumpHTSJNJxlNoNmleorWk8xhwN1BDYtZUqIjqxHdLvHnVy9R6K9755nXKV9vzbWLVCRIn0mSPhRqFJs70Rde0JDgESk-K6thH4qLfNJw";
                String RegisterId = user.getRegistrationid();
                return _broadcastRepository.sendBroadcastMsg(Msg, RegisterId);
            }
        }
        return false;
    }
    
}
