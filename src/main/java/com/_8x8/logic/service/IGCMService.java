/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.presentation.model.GCM;
import java.util.List;

/**
 *
 * @author ttran
 */
public interface IGCMService {

    public List<GCM> GetGCMs();

    public GCM GetGCMById(int Id);

    public int InsertGCM(GCM gcm);

    public void UpdateGCMById(GCM gcm);

    public void RemoveGCMById(int Id);
}
