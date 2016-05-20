package com._8x8.data.repository;

import com._8x8.presentation.model.UserPhoneLog;
import java.util.List;

public interface IUserPhoneLogRepository {
    public List<UserPhoneLog> getAllUserPhoneLog();
    public void insertUserPhoneLog(UserPhoneLog userPhoneLog);
    public void updateUserPhoneLog(UserPhoneLog userPhoneLog);
    public void deleteUserPhoneLogById(Integer Id);
    public void deleteUserPhoneLogByUserId(Integer userId);
}
