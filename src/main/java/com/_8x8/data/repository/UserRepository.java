package com._8x8.data.repository;

import com._8x8.logic.service.IEncryptorService;
import com._8x8.presentation.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends ConnectorHelper implements IUserRepository {

    @Autowired
    IEncryptorService _encryptorService;

    @Override
    public List<User> GetUsers() {
        List<Map<String, Object>> rs;
        List<User> mUsers = new ArrayList<>();

        try {
            rs = this.ExecuteQuery("select * from z8x8User");
            for (Map<String, Object> r : rs) {
                Iterator entries = r.entrySet().iterator();
                User mUser = new User();
                while (entries.hasNext()) {
                    Map.Entry pair = (Map.Entry) entries.next();
                    switch (pair.getKey().toString()) {
                        case "Id":
                            String id = pair.getValue().toString();
                            mUser.setId(Integer.parseInt(id));
                            try {
                                mUser.setQrCode(_encryptorService.encryptCode(id));
                            } catch (Exception ex) {
                                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case "firstname":
                            mUser.setFirstname(pair.getValue().toString());
                            break;
                        case "lastname":
                            mUser.setLastname(pair.getValue().toString());
                            break;
                        case "username":
                            mUser.setUsername(pair.getValue().toString());
                            break;
                        case "password":
                            mUser.setPassword(pair.getValue().toString());
                            break;
                        case "gender":
                            mUser.setGender(pair.getValue().toString());
                            break;
                        case "email":
                            mUser.setEmail(pair.getValue().toString());
                            break;
                        case "telephone":
                            mUser.setTelephone(pair.getValue().toString());
                            break;
                        case "address":
                            mUser.setAddress(pair.getValue().toString());
                            break;
                    }
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    entries.remove(); // avoids a ConcurrentModificationException
                }
                mUsers.add(mUser);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mUsers;
    }

    @Override
    public User GetUserById(int Id) {
        List<Map<String, Object>> rs;
        User mUser = new User();
        try {
            rs = this.ExecuteQuery("select * from z8x8User where id=" + Id);
            for (Map<String, Object> r : rs) {
                Iterator entries = r.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry pair = (Map.Entry) entries.next();
                    switch (pair.getKey().toString()) {
                        case "Id":
                            String id = pair.getValue().toString();
                            mUser.setId(Integer.parseInt(id));
                            try {
                                mUser.setQrCode(_encryptorService.encryptCode(id));
                            } catch (Exception ex) {
                                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case "firstname":
                            mUser.setFirstname(pair.getValue().toString());
                            break;
                        case "lastname":
                            mUser.setLastname(pair.getValue().toString());
                            break;
                        case "username":
                            mUser.setUsername(pair.getValue().toString());
                            break;
                        case "password":
                            mUser.setPassword(pair.getValue().toString());
                            break;
                        case "gender":
                            mUser.setGender(pair.getValue().toString());
                            break;
                        case "email":
                            mUser.setEmail(pair.getValue().toString());
                            break;
                        case "telephone":
                            mUser.setTelephone(pair.getValue().toString());
                            break;
                        case "address":
                            mUser.setAddress(pair.getValue().toString());
                            break;
                    }
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    entries.remove(); // avoids a ConcurrentModificationException
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mUser;
    }

    @Override
    public void UpdateUserById(User user) {
        String sql = "UPDATE [dbo].[z8x8User] "
                + "SET "
                + " firstname=" + user.getFirstname() + ", "
                + " lastname=" + user.getLastname() + ", "
                + " username=" + user.getUsername() + ", "
                + " password=" + user.getPassword() + ", "
                + " gender=" + user.getGender() + ", "
                + " telephone=" + user.getTelephone() + ", "
                + " email=" + user.getEmail() + ", "
                + " address=" + user.getAddress()
                + " WHERE Id=" + user.getId();
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void RemoveUserById(int id) {
        String sql = "delete [dbo].[z8x8User] WHERE Id=" + id;
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int InsertUser(User user) {
        int insertedId = 0;
        List<Map<String, Object>> rs;
        String sql = "INSERT INTO  [dbo].[z8x8User]  (firstname, lastname, username, password, gender, email, telephone, address) \n"
                + "OUTPUT Inserted.Id "
                + "values ( "
                + "'" + user.getFirstname() + "', "
                + "'" + user.getLastname() + "', "
                + "'" + user.getUsername() + "', "
                + "'" + user.getPassword() + "', "
                + "'" + user.getGender() + "', "
                + "'" + user.getEmail() + "', "
                + "'" + user.getTelephone() + "', "
                + "'" + user.getAddress()
                + "')";
        try {
            rs = this.ExecuteQuery(sql);
            for (Map.Entry pair : rs.get(0).entrySet()) {
                System.out.println(pair.getValue());
                insertedId = Integer.parseInt(pair.getValue().toString());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertedId;
    }

}
