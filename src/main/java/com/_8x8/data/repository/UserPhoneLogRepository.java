package com._8x8.data.repository;

import com._8x8.data.helper.ConnectorHelper;
import java.util.List;
import com._8x8.presentation.model.UserPhoneLog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UserPhoneLogRepository extends ConnectorHelper implements IUserPhoneLogRepository {

    @Override
    public List<UserPhoneLog> getAllUserPhoneLog() {
        List<Map<String, Object>> rs;
        List<UserPhoneLog> mUserPhoneLogs = new ArrayList<>();

        try {
            rs = this.ExecuteQuery("select * from z8x8UserPhoneLogs");
            for (Map<String, Object> r : rs) {
                Iterator entries = r.entrySet().iterator();
                UserPhoneLog mUserPhoneLog = new UserPhoneLog();
                while (entries.hasNext()) {
                    Map.Entry pair = (Map.Entry) entries.next();
                    switch (pair.getKey().toString()) {
                        case "Id":
                            mUserPhoneLog.setId(Integer.parseInt(pair.getValue().toString()));
                            break;
                        case "userId":
                            mUserPhoneLog.setUserId(Integer.parseInt(pair.getValue().toString()));
                            break;
                        case "answer":
                            mUserPhoneLog.setAnswer(Boolean.parseBoolean(pair.getValue().toString()));
                            break;
                        case "transfer":
                            mUserPhoneLog.setTrasfer(Boolean.parseBoolean(pair.getValue().toString()));
                            break;
                        case "missed":
                            mUserPhoneLog.setMissed(Boolean.parseBoolean(pair.getValue().toString()));
                            break;
                        case "timestamp":
                            mUserPhoneLog.setTimestamp(pair.getValue().toString());
                            break;
                    }
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    entries.remove(); // avoids a ConcurrentModificationException
                }
                mUserPhoneLogs.add(mUserPhoneLog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mUserPhoneLogs;
    }

    @Override
    public void insertUserPhoneLog(UserPhoneLog userPhoneLog) {
        String sql = "INSERT INTO  [dbo].[z8x8UserPhoneLogs]  (userId, answer, transfer, missed,timestamp) \n"
                + "values ( "
                + userPhoneLog.getUserId() + ", "
                + (userPhoneLog.getAnswer() ? 1 : 0) + ", "
                + (userPhoneLog.getTrasfer() ? 1 : 0) + ", "
                + (userPhoneLog.getMissed() ? 1 : 0) + ", '9/3/2015')";
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUserPhoneLog(UserPhoneLog userPhoneLog) {
        String sql = "UPDATE [dbo].[z8x8UserPhoneLogs] "
                + "SET "
                + " answer=" + (userPhoneLog.getAnswer() ? 1 : 0) + ", "
                + " transfer=" + (userPhoneLog.getTrasfer() ? 1 : 0) + ", "
                + " missed=" + (userPhoneLog.getMissed() ? 1 : 0)
                + " WHERE Id=" + userPhoneLog.getId();
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUserPhoneLogById(Integer Id) {
        String sql = "delete [dbo].[z8x8UserPhoneLogs] WHERE Id=" + Id;
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUserPhoneLogByUserId(Integer userId) {
        String sql = "delete [dbo].[z8x8UserPhoneLogs] WHERE userId=" + userId;
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
