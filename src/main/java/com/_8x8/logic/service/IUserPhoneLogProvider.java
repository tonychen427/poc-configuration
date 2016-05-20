/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.presentation.model.UserPhoneLogList;
import java.util.List;

/**
 *
 * @author Insprion
 */
public interface IUserPhoneLogProvider {
    
     public List<UserPhoneLogList> getUserPhoneLogList();
    
}
