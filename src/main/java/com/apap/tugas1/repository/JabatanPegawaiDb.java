package com.apap.tugas1.repository;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanPegawaiDb extends JpaRepository<JabatanPegawaiModel, Long> {
    // List<JabatanModel> findAllByPegawai(long id);
    JabatanModel findByPegawai(PegawaiModel pegawai);
};