/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.data.repository;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Repository;

@Repository
public class EncryptorRepository implements IEncryptorRepository {

    @Override
    public String encrypt(String dataToBeEncrypted) throws Exception {
        String encoded = DatatypeConverter.printBase64Binary(dataToBeEncrypted.getBytes());
        return encoded;
    }

    @Override
    public String decrypt(String encryptedData) throws Exception {
         String decoded = new String(DatatypeConverter.parseBase64Binary(encryptedData));
        return decoded;
    }

}
