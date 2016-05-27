/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.data.repository.IGCMRepository;
import com._8x8.presentation.model.GCM;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GCMService implements IGCMService{

    @Autowired
    IGCMRepository _gcmRepository;
    
    @Override
    public List<GCM> GetGCMs() {
        return _gcmRepository.GetGCMs();
    }

    @Override
    public GCM GetGCMById(int Id) {
        return _gcmRepository.GetGCMById(Id);
    }

    @Override
    public int InsertGCM(GCM gcm) {
        return _gcmRepository.InsertGCM(gcm);
    }

    @Override
    public void UpdateGCMById(GCM gcm) {
        _gcmRepository.UpdateGCMById(gcm);
    }

    @Override
    public void RemoveGCMById(int Id) {
        _gcmRepository.RemoveGCMById(Id);
    }    
}
