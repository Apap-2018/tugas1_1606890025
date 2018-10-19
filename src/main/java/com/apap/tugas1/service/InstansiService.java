package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface InstansiService {
    List<InstansiModel> getAll();
    InstansiModel getInstansi(long id);
    boolean addInstansi(InstansiModel instansi); 
    boolean removeInstansi(InstansiModel instansi);
}