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

    @Override
    public void addJabatanPegawai(JabatanModel jabatan, PegawaiModel pegawai) {
        JabatanPegawaiModel jabatanPegawai = new JabatanPegawaiModel();
        jabatanPegawai.setJabatan(jabatan);
        jabatanPegawai.setPegawai(pegawai);
        jabatanPegawaiDb.save(jabatanPegawai);
    }

    @Override
    public boolean removeJabatanPegawai(JabatanPegawaiModel jabatanPegawai) {
        return false;
	}

    // @Override
    // public List<PegawaiModel> getPegawaiWithJabatan(JabatanModel jabatan) {
    //     return jabatanPegawaiDb.findByJabatan(jabatan)
    // }

}