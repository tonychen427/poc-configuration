/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.presentation.restfulController;

import com._8x8.logic.service.IBroadcastService;
import com._8x8.logic.service.IEncryptorService;
import com._8x8.logic.service.IUserService;
import com._8x8.presentation.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zPay")
public class ZPayRestfulController {

    @Autowired
    IUserService _userService;  //Service which will do all data retrieval/manipulation work

    @Autowired
    IEncryptorService _encryptorService;

    @Autowired
    IBroadcastService _broadcastService;
    
    @RequestMapping(value = "/broadcastMsgByQRCode/{qrCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> broadcastMsgByQRCode(@PathVariable("qrCode") String qrCode) {
    
        try {
             Boolean broadcast = _broadcastService.SendBroadcastMsg("SomeMessage", qrCode);    
             return new ResponseEntity<String>(broadcast.toString(), HttpStatus.OK);
        }catch (Exception ex) {
             return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/decryptQRCode/{qrCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> decryptQRCode(@PathVariable("qrCode") String qrCode) {

        try {


            String code = _encryptorService.decryptCode(qrCode);
            return new ResponseEntity<String>(code, HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(ZPayRestfulController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

    }


    @RequestMapping(value = "/getVendorInfoByQRCode/{qrCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> listVendorUsers(@PathVariable("qrCode") String qrCode) {

        try {
            String code = _encryptorService.decryptCode(qrCode);
            int id = Integer.parseInt(code);
            User user = _userService.GetUserById(id);
            if (user == null) {
                System.out.println("User with id " + id + " not found");
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<User>(user, HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(ZPayRestfulController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
}
