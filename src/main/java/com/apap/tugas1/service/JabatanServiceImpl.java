package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService {
    @Autowired
    private JabatanDb jabatanDb;

    @Override
    public List<JabatanModel> getAll() {
        return jabatanDb.findAll();
    }

    @Override
    public JabatanModel getJabatan(String nama) {
        return jabatanDb.findByNama(nama);
    }
    
    @Override
    public JabatanModel getJabatanById(long id) {
        return jabatanDb.getOne(id);
    }

    @Override
    public void addJabatan(JabatanModel jabatan) {
        jabatanDb.save(jabatan);
    }

    @Override
	public void removeJabatan(JabatanModel jabatan) {
        if( jabatanDb.getOne(jabatan.getId()).getJabatanPegawai().isEmpty() ) jabatanDb.deleteById(jabatan.getId());
	}

    @Override
    public void updateJabatan(JabatanModel jabatan) {
        JabatanModel jabatanInDb = jabatanDb.getOne(jabatan.getId());
        jabatanInDb.setNama(jabatan.getNama());
        jabatanInDb.setDeskripsi(jabatan.getDeskripsi());
        jabatanInDb.setGajiPokok(jabatan.getGajiPokok());
    }

}