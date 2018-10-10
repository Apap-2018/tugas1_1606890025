package com.apap.tugas1.controller;

import java.util.List;
import java.util.Set;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PegawaiController {
    @Autowired private PegawaiService pegawaiService;
    @Autowired private ProvinsiService provinsiService;
    @Autowired private JabatanService jabatanService;
    @Autowired private InstansiService instansiService;
    @Autowired private JabatanPegawaiService jabatanPegawaiService;

    // FITUR 1
    @RequestMapping(value="/")
    public String index(Model model) {
        List<JabatanModel> jabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", jabatan);
        return "index";
    }
    
    @RequestMapping(value="/pegawai", method=RequestMethod.GET)
    public String getPegawai(@RequestParam(value="nip", required=true) String nip, Model model) {
        PegawaiModel pegawai = pegawaiService.getPegawai(nip);
        Set<JabatanPegawaiModel> jabatan = pegawai.getJabatanPegawai();
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("jabatan", jabatan);

        // todo add jabatan & gaji
        return "getPegawai";
    }

    // FITUR 2
    @RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
    public String addPegawai(Model model) {
        List<ProvinsiModel> provinsi = provinsiService.getAll();
        List<InstansiModel> instansi = instansiService.getAll();
        List<JabatanModel> jabatan = jabatanService.getAll();
        model.addAttribute("provinsi", provinsi);
        model.addAttribute("instansi", instansi);
        model.addAttribute("jabatan", jabatan);
        return "addPegawai";
    }

    @RequestMapping(value="/pegawai/tambah", method=RequestMethod.POST)
    public String addPegawaiSubmit( @ModelAttribute PegawaiModel pegawai,
                                    @ModelAttribute JabatanModel jabatan,
                                    Model model) {
        // pegawai.setnip
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("jabatan", jabatan);
        return "responsePage";
    }

    // FITUR 3
    @RequestMapping(value="/pegawai/ubah", method=RequestMethod.GET)
    public String editPegawai(@RequestParam(value="nip", required=true) String nip, Model model) {
        return "editPegawai";
    }

    @RequestMapping(value="/pegawai/ubah", method=RequestMethod.POST)
    public String editPegawaiSubmit(Model model) {
        return "responsePage";
    }

    // FITUR 4 
    @RequestMapping(value="/pegawai/cari", method=RequestMethod.GET)
    public String findPegawai(Model model) {
        return "findPegawai";
    }

    @RequestMapping(value="/pegawai/cari", method=RequestMethod.POST)
    public String findPegawaiSubmit(@RequestParam("provinsi") String idProvinsi,
                                    @RequestParam("instansi") String idInstansi,
                                    @RequestParam("jabatan") String idJabatan,
                                    Model model) {
        return "findPegawai";   
    }
    

    // FITUR 10
    @RequestMapping(value="/pegawai/termuda-tertua", method=RequestMethod.GET)
    public String youngestOldestPegawai(@RequestParam(value="idInstansi", required=true) String idInstansi, Model model) {
        return "youngestOldestPegawai";
    }

    // BONUS
}