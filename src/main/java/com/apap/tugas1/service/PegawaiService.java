package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;

public interface PegawaiService {
    PegawaiModel getPegawai(String nip);
    
    PegawaiModel getOldestPegawai(InstansiModel instansi);
    PegawaiModel getYoungestPegawai(InstansiModel instansi);

    List<PegawaiModel> getPegawaiByProvinsi(ProvinsiModel provinsi);
    List<PegawaiModel> getPegawaiByProvinsiAndJabatan(ProvinsiModel provinsi, JabatanModel jabatan);
    List<PegawaiModel> getPegawaiByInstansi(InstansiModel instansi);
    List<PegawaiModel> getPegawaiByInstansiAndJabatan(InstansiModel instansi, JabatanModel jabatan);
    List<PegawaiModel> getPegawaiByJabatan(JabatanModel jabatan);

    void addPegawai(PegawaiModel pegawai);
    void updatePegawai(PegawaiModel pegawai);        
}