package com._8x8.data.repository;

import com._8x8.presentation.model.GCM;
import java.util.List;

public interface IGCMRepository {
    public List<GCM> GetGCMs();
    public GCM GetGCMById(int Id);
    public int InsertGCM(GCM gcm);
    public void UpdateGCMById(GCM gcm);
    public void RemoveGCMById(int Id);
}
