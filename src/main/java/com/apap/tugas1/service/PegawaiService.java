package com.apap.tugas1.service;

import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
    PegawaiModel getPegawai(String nip);
    boolean addPegawai(PegawaiModel pegawai);
    boolean removePegawai(PegawaiModel pegawai);
}