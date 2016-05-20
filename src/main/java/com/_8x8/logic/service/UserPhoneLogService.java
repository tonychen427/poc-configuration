package com._8x8.logic.service;

import java.util.List;
import com._8x8.data.repository.IUserPhoneLogRepository;
import com._8x8.data.repository.IUserRepository;
import com._8x8.presentation.model.User;
import com._8x8.presentation.model.UserPhoneLog;
import com._8x8.presentation.model.UserPhoneLogList;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPhoneLogService implements IUserPhoneLogService {

    @Autowired
    IUserRepository _userRepository;

    @Autowired
    IUserPhoneLogRepository _userPhoneLogRepository;

    @Override
    public void insertUserPhoneLog(UserPhoneLog userPhoneLog) {
        _userPhoneLogRepository.insertUserPhoneLog(userPhoneLog);
    }

    @Override
    public void updateUserPhoneLog(UserPhoneLog userPhoneLog) {
        _userPhoneLogRepository.updateUserPhoneLog(userPhoneLog);
    }

    @Override
    public void deleteUserPhoneLogById(Integer Id) {
        _userPhoneLogRepository.deleteUserPhoneLogById(Id);
    }

    @Override
    public void deleteUserPhoneLogByUserId(Integer userId) {
        _userPhoneLogRepository.deleteUserPhoneLogByUserId(userId);
    }

    @Override
    public int getTotalAnswerByUserPhoneLog(List<UserPhoneLog> userPhoneLog) {
        int totalAnswer = 0;
        for (UserPhoneLog userPhoneLogData : userPhoneLog) {
            if (userPhoneLogData.getAnswer()) {
                totalAnswer++;
            }
        }
        return totalAnswer;
    }

    @Override
    public int getTotalTransferByUserPhoneLog(List<UserPhoneLog> userPhoneLog) {
        int totalTransfer = 0;
        for (UserPhoneLog userPhoneLogData : userPhoneLog) {
            if (userPhoneLogData.getTrasfer()) {
                totalTransfer++;
            }
        }
        return totalTransfer;
    }

    @Override
    public int getTotalMissedByUserPhoneLog(List<UserPhoneLog> userPhoneLog) {
        int totalMissed = 0;
        for (UserPhoneLog userPhoneLog1 : userPhoneLog) {
            if (userPhoneLog1.getMissed()) {
                totalMissed++;
            }
        }
        return totalMissed;
    }

    @Override
    public int getTotalAnswerByUserId(Integer userId) {
        List<UserPhoneLog> mUserPhoneLog = this.getUserPhoneLogByUserId(userId);
        int totalAnswer = this.getTotalTransferByUserPhoneLog(mUserPhoneLog);
        return totalAnswer;
    }

    @Override
    public int getTotalTransferByUserId(Integer userId) {
        List<UserPhoneLog> mUserPhoneLog = this.getUserPhoneLogByUserId(userId);
        int totalTransfer = this.getTotalTransferByUserPhoneLog(mUserPhoneLog);
        return totalTransfer;
    }

    @Override
    public int getTotalMissedByUserId(Integer userId) {
        List<UserPhoneLog> mUserPhoneLog = this.getUserPhoneLogByUserId(userId);
        int totalMissed = this.getTotalAnswerByUserPhoneLog(mUserPhoneLog);
        return totalMissed;
    }

    @Override
    public List<UserPhoneLog> getAllPhoneLog() {
        return _userPhoneLogRepository.getAllUserPhoneLog();
    }

    @Override
    public List<UserPhoneLog> getUserPhoneLogByUserId(Integer userId) {
        List<UserPhoneLog> mUserPhoneLogs = new ArrayList<>();
        List<UserPhoneLog> mAllUserPhoneLogs = _userPhoneLogRepository.getAllUserPhoneLog();
        Integer tempUserId;
        for (UserPhoneLog allUserPhoneLogData : mAllUserPhoneLogs) {
            tempUserId = allUserPhoneLogData.getUserId();
            if (tempUserId.equals(userId)) {
                mUserPhoneLogs.add(allUserPhoneLogData);
            }
        }
        return mUserPhoneLogs;
    }

    @Override
    public List<UserPhoneLogList> getUserPhoneLogList() {
        List<UserPhoneLogList> mUserPhoneLogList = new ArrayList<>();
        List<User> mUser = _userRepository.GetUsers();

        for (User mUserData : mUser) {
            Integer userId = mUserData.getId();
            String fullname = mUserData.getFirstname() + " " + mUserData.getLastname();

            List<UserPhoneLog> mUserPhoneLog = this.getUserPhoneLogByUserId(userId);
            int totalAnswer = this.getTotalAnswerByUserPhoneLog(mUserPhoneLog);
            int totalTransfer = this.getTotalTransferByUserPhoneLog(mUserPhoneLog);
            int totalMissed = this.getTotalMissedByUserPhoneLog(mUserPhoneLog);

            mUserPhoneLogList.add(new UserPhoneLogList(userId, fullname, totalAnswer, totalTransfer, totalMissed));
        }

        return mUserPhoneLogList;
    }

}
