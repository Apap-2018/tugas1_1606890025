package com.apap.tugas1.service;

import java.time.LocalDate;
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
        pegawai.setNip(this.generateNip(pegawai));
        
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

    private String generateNip(PegawaiModel pegawai) {
        String result = "";
        result += pegawai.getInstansi().getId();
        LocalDate date = pegawai.getTanggalLahir().toLocalDate();
        result += date.getDayOfMonth() < 10 ? "0" + date.getDayOfMonth() : date.getDayOfMonth();
        result += date.getMonthValue() < 10 ? "0" + date.getMonthValue() : date.getMonthValue();
        result += date.getYear() < 10 ? "0" + date.getYear() : date.getYear() % 100;
        result += pegawai.getTahunMasuk();
        int lastTwo = pegawaiDb.findByTanggalLahirAndTahunMasukOrderByTanggalLahirAscTahunMasukAsc(pegawai.getTanggalLahir(), pegawai.getTahunMasuk()).size();
        result += lastTwo < 10 ? "0" + lastTwo : lastTwo;
        
        return result;
    }

    @Override
    public PegawaiModel getOldestPegawai(InstansiModel instansi) {
        return pegawaiDb.findByInstansiOrderByTanggalLahirDesc(instansi).get(0);
    }

    @Override
    public PegawaiModel getYoungestPegawai(InstansiModel instansi) {
        return pegawaiDb.findByInstansiOrderByTanggalLahirAsc(instansi).get(0);
    }
}