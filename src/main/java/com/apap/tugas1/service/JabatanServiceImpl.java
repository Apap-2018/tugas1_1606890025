package com.apap.tugas1.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.PersistenceException;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateJdbcException;
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
	public boolean removeJabatan(JabatanModel jabatan) {
        try {
            jabatanDb.deleteById(jabatan.getId());
            return true;
        } catch(Exception e) {
            return false;
        }
        // if( jabatanDb.getOne(jabatan.getId()).getJabatanPegawai().isEmpty() ) 
	}

    @Override
    public void updateJabatan(JabatanModel jabatan) {
        JabatanModel jabatanInDb = jabatanDb.getOne(jabatan.getId());
        jabatanInDb.setNama(jabatan.getNama());
        jabatanInDb.setDeskripsi(jabatan.getDeskripsi());
        jabatanInDb.setGajiPokok(jabatan.getGajiPokok());
    }

}