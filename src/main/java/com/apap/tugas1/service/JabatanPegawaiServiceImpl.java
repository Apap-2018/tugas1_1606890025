package com.apap.tugas1.service;

import java.util.List;
import java.util.Set;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.JabatanDb;
import com.apap.tugas1.repository.JabatanPegawaiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JabatanPegawaiServiceImpl implements JabatanPegawaiService {
    @Autowired private JabatanPegawaiDb jabatanPegawaiDb;
    @Autowired private JabatanDb jabatanDb;

    @Override
    public List<JabatanModel> getJabatanPegawai(PegawaiModel pegawai) {
        // return jabatans;
        return null;
    }

    @Override
    public boolean addJabatanPegawai(JabatanPegawaiModel jabatanPegawai) {
        return false;
    }

    @Override
    public boolean removeJabatanPegawai(JabatanPegawaiModel jabatanPegawai) {
        return false;
	}

}