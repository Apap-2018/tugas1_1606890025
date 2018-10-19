package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;

public interface JabatanService {
    List<JabatanModel> getAll();
    JabatanModel getJabatan(String nama);
    JabatanModel getJabatanById(long id);
    void addJabatan(JabatanModel jabatan); 
    boolean removeJabatan(JabatanModel jabatan);
    void updateJabatan(JabatanModel jabatan);
}