package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface JabatanPegawaiService {
    // List<PegawaiModel> getPegawaiWithJabatan(JabatanModel pegawai);
    void addJabatanPegawai(JabatanModel jabatan, PegawaiModel pegawai); 
    boolean removeJabatanPegawai(JabatanPegawaiModel jabatanPegawai);
}