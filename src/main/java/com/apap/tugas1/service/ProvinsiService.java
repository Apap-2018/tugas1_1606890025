package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.ProvinsiModel;

public interface ProvinsiService {
    List<ProvinsiModel> getAll();
    ProvinsiModel getProvinsi(String nip);
    boolean addProvinsi(ProvinsiModel provinsi);
    boolean removeProvinsi(ProvinsiModel provinsi);
};