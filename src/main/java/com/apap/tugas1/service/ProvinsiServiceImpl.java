package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.ProvinsiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {
    @Autowired
    private ProvinsiDb provinsiDb;

    @Override
    public List<ProvinsiModel> getAll() {
        return provinsiDb.findAll();
    }

    @Override
    public ProvinsiModel getProvinsi(String nama) {
        return provinsiDb.findByNama(nama);
    }

    @Override
    public boolean addProvinsi(ProvinsiModel provinsi) {
        return false;
    }

    @Override
    public boolean removeProvinsi(ProvinsiModel provinsi) {
		return false;
	}

}