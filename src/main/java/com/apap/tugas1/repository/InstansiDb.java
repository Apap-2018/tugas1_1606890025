package com.apap.tugas1.repository;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstansiDb extends JpaRepository<InstansiModel, Long> {
    InstansiModel findByNama(String nama);
    List<InstansiModel> findByProvinsi(ProvinsiModel provinsi);
};