/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.data.repository;

/**
 *
 * @author ttran
 */
public interface IBroadcastRepository {
    public Boolean sendBroadcastMsg (String msg, String RegisterId);
}
