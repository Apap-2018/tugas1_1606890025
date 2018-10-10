package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.InstansiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstansiServiceImpl implements InstansiService {
    @Autowired
    private InstansiDb instansidb;

    @Override
    public List<InstansiModel> getAll() {
        return instansidb.findAll();
    }

    @Override
    public InstansiModel getInstansi(String nama) {
        return null;
    }

    @Override
    public boolean addInstansi(InstansiModel instansi) {
        return false;
    }

	@Override
	public boolean removeInstansi(InstansiModel instansi) {
		return false;
	}

}