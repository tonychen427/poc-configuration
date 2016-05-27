package com._8x8.data.repository;

import com._8x8.data.helper.ConnectorHelper;
import com._8x8.presentation.model.GCM;
import com._8x8.presentation.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class GCMRepository extends ConnectorHelper implements IGCMRepository{

    @Override
    public List<GCM> GetGCMs() {
        List<Map<String, Object>> rs;
        List<GCM> mGCMs = new ArrayList<>();

        try {
            rs = this.ExecuteQuery("select * from z8x8GCMInfo");
            for (Map<String, Object> r : rs) {
                Iterator entries = r.entrySet().iterator();
                GCM mGCM = new GCM();
                while (entries.hasNext()) {
                    Map.Entry pair = (Map.Entry) entries.next();
                    switch (pair.getKey().toString()) {
                        case "Id":                            
                            mGCM.setId(Integer.parseInt(pair.getValue().toString()));                          
                            break;
                        case "gcmSendURL":
                            mGCM.setGcmSendURL(pair.getValue().toString());
                            break;
                        case "gcmProjectNumber":
                            mGCM.setGcmProjectNumber(pair.getValue().toString());
                            break;
                        case "gcmAPIKey":
                            mGCM.setGcmAPIKey(pair.getValue().toString());
                            break;                       
                    }
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    entries.remove(); // avoids a ConcurrentModificationException
                }
                mGCMs.add(mGCM);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GCMRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mGCMs;
    }

    @Override
    public GCM GetGCMById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int InsertGCM(GCM gcm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateGCMById(GCM gcm) {
         String sql = "UPDATE [dbo].[z8x8GCMInfo] "
                + "SET "
                + " gcmSendURL=" + gcm.getGcmSendURL() + ", "
                + " gcmProjectNumber=" + gcm.getGcmProjectNumber() + ", "
                + " gcmAPIKey=" + gcm.getGcmAPIKey()
                + " WHERE Id=" + gcm.getId();
        try {
            this.ExecuteQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserPhoneLogRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void RemoveGCMById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
