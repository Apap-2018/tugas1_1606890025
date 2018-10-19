package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
    PegawaiModel getPegawai(String nip);
    
    PegawaiModel getOldestPegawai(InstansiModel instansi);
    PegawaiModel getYoungestPegawai(InstansiModel instansi);

    List<PegawaiModel> getPegawaiByInstansi(InstansiModel instansi);
    List<PegawaiModel> getPegawaiByJabatan(JabatanModel jabatan);
    List<PegawaiModel> getPegawaiByInstansiAndJabatan(InstansiModel instansi, JabatanModel jabatan);

    void addPegawai(PegawaiModel pegawai);
    boolean removePegawai(PegawaiModel pegawai);
}