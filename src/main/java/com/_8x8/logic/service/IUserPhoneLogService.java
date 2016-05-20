package com._8x8.logic.service;

import com._8x8.presentation.model.UserPhoneLog;
import com._8x8.presentation.model.UserPhoneLogList;
import java.util.List;

public interface IUserPhoneLogService {

    public void insertUserPhoneLog(UserPhoneLog userPhoneLog);
    public void updateUserPhoneLog(UserPhoneLog userPhoneLog);
    public void deleteUserPhoneLogById(Integer Id);
    public void deleteUserPhoneLogByUserId(Integer userId);
    
    
    public int getTotalAnswerByUserPhoneLog(List<UserPhoneLog> userPhoneLog);

    public int getTotalTransferByUserPhoneLog(List<UserPhoneLog> userPhoneLog);

    public int getTotalMissedByUserPhoneLog(List<UserPhoneLog> userPhoneLog);

    public int getTotalAnswerByUserId(Integer userId);

    public int getTotalTransferByUserId(Integer userId);

    public int getTotalMissedByUserId(Integer userId);

    public List<UserPhoneLog> getAllPhoneLog();

    public List<UserPhoneLog> getUserPhoneLogByUserId(Integer userId);

    public List<UserPhoneLogList> getUserPhoneLogList();

}
