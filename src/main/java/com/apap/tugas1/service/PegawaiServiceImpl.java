package com.apap.tugas1.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.JabatanPegawaiDb;
import com.apap.tugas1.repository.PegawaiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
    @Autowired private PegawaiDb pegawaiDb;
    @Autowired private JabatanPegawaiDb jabatanPegawaiDb;
    // todo may be dipindahin

    @Override
    public PegawaiModel getPegawai(String nip) {
        return pegawaiDb.findByNip(nip);
    }

    @Override
    public List<PegawaiModel> getPegawaiByInstansi(InstansiModel instansi) {
        return pegawaiDb.findByInstansi(instansi);
    }

    @Override
    public List<PegawaiModel> getPegawaiByJabatan(JabatanModel jabatan) {
        List<PegawaiModel> result = new ArrayList<>();
        for (JabatanPegawaiModel jabatanPegawai : jabatan.getJabatanPegawai()) {
            result.add(jabatanPegawai.getPegawai());
        }
        return result;
    }

    @Override
    public List<PegawaiModel> getPegawaiByInstansiAndJabatan(InstansiModel instansi, JabatanModel jabatan) {
        List<PegawaiModel> jabatanResult = this.getPegawaiByJabatan(jabatan);
        List<PegawaiModel> instansiResult = this.getPegawaiByInstansi(instansi);
        
        jabatanResult.retainAll(instansiResult);
        return jabatanResult;
	}

    @Override
    public void addPegawai(PegawaiModel pegawai) {
        pegawai.setNip();
        
        List<JabatanPegawaiModel> temp = pegawai.getJabatanPegawai();
        pegawai.setJabatanPegawai(new ArrayList<>());

        pegawaiDb.save(pegawai);
        
        for (JabatanPegawaiModel jabatanPegawai : temp) {
            jabatanPegawai.setPegawai(pegawai);
            jabatanPegawaiDb.save(jabatanPegawai);
        }

    }

    @Override
    public boolean removePegawai(PegawaiModel pegawai) {
        return false;
    }

}