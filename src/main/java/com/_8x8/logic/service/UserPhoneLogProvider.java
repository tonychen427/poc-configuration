/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.data.repository.IUserPhoneLogRepository;
import com._8x8.data.repository.IUserRepository;
import com._8x8.presentation.model.User;
import com._8x8.presentation.model.UserPhoneLog;
import com._8x8.presentation.model.UserPhoneLogList;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPhoneLogProvider implements IUserPhoneLogProvider {

    @Autowired
    IUserRepository _userRepository;

    @Autowired
    IUserPhoneLogRepository _userPhoneLogRepository;

    @Override
    public List<UserPhoneLogList> getUserPhoneLogList() {
        List<UserPhoneLogList> mUserPhoneLogList = new ArrayList<>();
        List<User> mUser = _userRepository.GetUsers();
        List<UserPhoneLog> mAllUserPhoneLogs = _userPhoneLogRepository.getAllUserPhoneLog();
        
        for (User mUserData : mUser) {
            Integer userId = mUserData.getId();
            String fullname = mUserData.getFirstname() + " " + mUserData.getLastname();
            int totalAnswer = 0;
            int totalTransfer = 0;
            int totalMissed = 0;

            List<UserPhoneLog> mUserPhoneLogs = new ArrayList<>();
            Integer tempUserId;
            for (UserPhoneLog allUserPhoneLogData : mAllUserPhoneLogs) {
                tempUserId = allUserPhoneLogData.getUserId();
                if (tempUserId.equals(userId)) {
                    mUserPhoneLogs.add(allUserPhoneLogData);
                }
            }

            for (UserPhoneLog userPhoneLogData : mUserPhoneLogs) {
                if (userPhoneLogData.getAnswer()) {
                    totalAnswer++;
                }
            }
            for (UserPhoneLog userPhoneLogData : mUserPhoneLogs) {
                if (userPhoneLogData.getTrasfer()) {
                    totalTransfer++;
                }
            }
            for (UserPhoneLog userPhoneLog1 : mUserPhoneLogs) {
                if (userPhoneLog1.getMissed()) {
                    totalMissed++;
                }
            }
            mUserPhoneLogList.add(new UserPhoneLogList(userId, fullname, totalAnswer, totalTransfer, totalMissed));
        }

        return mUserPhoneLogList;
    }

}
