/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *    String encryptionKey = "MZygpewJsCpRrfOr";
 *    String plainText = "Hello world!";
 *    AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(
 *            encryptionKey);
 *    String cipherText = advancedEncryptionStandard.encrypt(plainText);
 *    String decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
 *
 *    System.out.println(plainText);
 *    System.out.println(cipherText);
 *    System.out.println(decryptedCipherText);
 *
 */
package com._8x8.data.repository;

/**
 *
 * @author ttran
 */
public interface IEncryptorRepository {

    public String encrypt(String plainText) throws Exception;

    public String decrypt(String encrypted) throws Exception;
}
