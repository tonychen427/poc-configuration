/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.data.repository;

import com._8x8.constant.GCM_Services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author Insprion
 */
public class ConnectorHelper {

    private static final String url = "jdbc:jtds:sqlserver://xdbs2.dailyrazor.com;instance=SQLEXPRESS;DatabaseName=clientsb_hsilaitemple";
    private static final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private static final String userName = "clien_888888";
    private static final String password = "888888";

    public List<Map<String, Object>> ExecuteQuery(String sql) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> row;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("connected");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            Integer columnCount = metaData.getColumnCount();
            while (rs.next()) {
                row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    int type = metaData.getColumnType(i);
                    switch (type) {
                        case Types.CLOB:
                            row.put(metaData.getColumnName(i), rs.getString(i));
                            break;
                        case Types.INTEGER:
                            row.put(metaData.getColumnName(i), rs.getInt(i));
                            break;
                        default:
                            row.put(metaData.getColumnName(i), rs.getObject(i));
                            break;
                    }

                }
                resultList.add(row);
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        System.out.println(sql);
        return resultList;
    }

    public String getValue(Iterator entries, String mKey) {
        String mValue = "";
        
        while (entries.hasNext()) {
            Map.Entry pair = (Map.Entry) entries.next();
            if(pair.getKey().equals(mKey)){
                mValue = pair.getValue().toString();
            }
            //System.out.println(pair.getKey() + " = " + pair.getValue());
          //  entries.remove(); // avoids a ConcurrentModificationException
        }
        return mValue;
    }

    public void IsConnectedToMSSQL() throws SQLException {

        Connection conn = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the database!!! Getting table list...");

            DatabaseMetaData dbm = conn.getMetaData();
            rs = dbm.getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
    
    
     public String sendHTTPData(String urlpath, JSONObject json) {
        HttpURLConnection connection = null;
        try {
            URL url=new URL(urlpath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "key=" + GCM_Services.api_key);
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            streamWriter.write(json.toString());
            streamWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String response = null;
                while ((response = bufferedReader.readLine()) != null) {
                    stringBuilder.append(response + "\n");
                }
                bufferedReader.close();

                //Log.d("test", stringBuilder.toString());
                return stringBuilder.toString();
            } else {
                //Log.e("test", connection.getResponseMessage());
                return null;
            }
        } catch (Exception exception){
            //Log.e("test", exception.toString());
            return null;
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
    }
}
