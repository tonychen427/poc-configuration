/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.data.repository;

import com._8x8.data.helper.ConnectorHelper;
import com._8x8.constant.GCM_Services;
import com._8x8.presentation.model.GCM;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Repository;

@Repository
public class BroadcastRepository extends ConnectorHelper implements IBroadcastRepository {

    @Override
    public Boolean sendBroadcastMsg(String msg, String RegisterId, GCM gcm) {        
   
        String jsonStr = "[  "
                + " {"
                + "   \"data\": {"
                + "       \"title\": \"Test Title\","
                + "       \"body\": \""+  msg +"\""
                + "   },"
                + " \"to\": \"" + RegisterId +"\""
                + " }]";

        try {
            JSONArray array = new JSONArray(jsonStr);
            this.sendGCMHTTPData(array.getJSONObject(0), gcm);
        } catch (JSONException ex) {
            Logger.getLogger(BroadcastRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
