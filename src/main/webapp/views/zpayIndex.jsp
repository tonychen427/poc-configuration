<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>zPay API Console - Sandbox</title>
        <style>
            .vendorAPIWrapper{
                width: 100%;
            }
            .vendorAPIWrapper thead tr > th {
                text-align: left;
            }
            .GCMWrapper {
                width: 100%;
            }
            .GCMWrapper .gcmValue {
                width: 100%;
            }
        </style>
    </head>
    <body>


        <table class="GCMWrapper">
            <thead>
                <tr>
                    <th colspan="3"><h1>zPay API Console - Sandbox</h1></th>
                </tr>                               
            </thead>
            <tr><td style='width:250px;'>GCM URL:</td><td><input class='gcmValue' value="${gcm.gcmSendURL}"></td></tr>
            <tr><td style='width:250px;'>Project Number:</td><td><input class='gcmValue' value="${gcm.gcmProjectNumber}"></td></tr>
            <tr><td style='width:250px;'>API Key:</td><td><input class='gcmValue' value="${gcm.gcmAPIKey}"></td></tr>
        </table>

        <br>

        <table class="vendorAPIWrapper">            
                <tr>
                    <th>QR Code</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone #</th>
                    <th>API</th>
                </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>            
                    <td><img src="/qrCode/${user.id}"></td>                    
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.email}</td>
                    <td>${user.telephone}</td>                    
                    <td>                        
                        <div>GET: /api/zPay/getVendorInfoByQRCode/${user.qrcode}</div>
                        <div>GET: /api/zPay/broadcastMsgByQRCode/${user.qrcode}</div>
                    </td>
                </tr>                
            </c:forEach>
            </table>
</body>
</html>
