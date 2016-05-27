/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.data.repository.IEncryptorRepository;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptorService implements IEncryptorService {

    @Autowired
    IEncryptorRepository _encryptorRepository;

    @Override
    public String encryptCode(String plainText) throws Exception {
        //String cipherText = _encryptorRepository.encrypt(plainText);
        // ** add more secure encrypt logic
        //return cipherText;
        
        String encoded = DatatypeConverter.printBase64Binary(plainText.getBytes());
        return encoded;
        
    }

    @Override
    public String decryptCode(String encrypted) throws Exception {
        //String decryptTxt = _encryptorRepository.decrypt(encrypted);
        // add more secure decrypt logic
        //return decryptTxt;
        
        String decoded = new String(DatatypeConverter.parseBase64Binary(encrypted));
        return decoded;
    }
}
