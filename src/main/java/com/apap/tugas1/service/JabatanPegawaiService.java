package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface JabatanPegawaiService {
    List<JabatanModel> getJabatanPegawai(PegawaiModel pegawai);
    boolean addJabatanPegawai(JabatanPegawaiModel jabatanPegawai); 
    boolean removeJabatanPegawai(JabatanPegawaiModel jabatanPegawai);
}