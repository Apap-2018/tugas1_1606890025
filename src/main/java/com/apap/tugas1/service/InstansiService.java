package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;

public interface InstansiService {
    List<InstansiModel> getAll();
    InstansiModel getInstansi(String nama);
    boolean addInstansi(InstansiModel instansi); 
    boolean removeInstansi(InstansiModel instansi);
}