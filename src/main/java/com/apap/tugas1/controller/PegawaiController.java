package com.apap.tugas1.controller;

import java.util.ArrayList;
import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PegawaiController {
    @Autowired private PegawaiService pegawaiService;
    @Autowired private ProvinsiService provinsiService;
    @Autowired private JabatanService jabatanService;
    @Autowired private InstansiService instansiService;

    /////////////////////////////////////////////////////////////////////// FITUR 1
    @RequestMapping(value="/")
    public String index(Model model) {
        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);
        model.addAttribute("listOfInstansi", listOfInstansi);
        return "index";
    }
    
    @RequestMapping(value="/pegawai", method=RequestMethod.GET)
    public String getPegawai(@RequestParam(value="nip", required=true) String nip, Model model) {
        PegawaiModel pegawai = pegawaiService.getPegawai(nip);
        List<JabatanPegawaiModel> jabatan = pegawai.getJabatanPegawai();
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("jabatan", jabatan);
        Double gaji = 0.0;
        for (JabatanPegawaiModel jab: jabatan) {
            if (jab.getJabatan().getGajiPokok() > gaji) gaji = jab.getJabatan().getGajiPokok();
        }
        gaji += gaji * pegawai.getInstansi().getProvinsi().getPresentaseTunjangan() / 100;
        model.addAttribute("gaji", gaji.intValue());
        return "getPegawai";
    }

    /////////////////////////////////////////////////////////////////////// FITUR 2
    @RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
    public String addPegawai(Model model) {
        PegawaiModel pegawai = new PegawaiModel();
        pegawai.setJabatanPegawai(new ArrayList());
        pegawai.addJabatanPegawai(new JabatanPegawaiModel());

        model.addAttribute("pegawai", pegawai);

        List<ProvinsiModel> listOfProvinsi = provinsiService.getAll();
        model.addAttribute("listOfProvinsi", listOfProvinsi);

        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfInstansi", listOfInstansi);

        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);

        return "addPegawai";
    }

    @RequestMapping(value="/pegawai/tambah", method=RequestMethod.POST, params={"add-row"})
    private String addPegawaiRowJabatan(@ModelAttribute PegawaiModel pegawai,
                                        BindingResult bindingResult, 
                                        Model model) {
        pegawai.getJabatanPegawai().add(new JabatanPegawaiModel());
        model.addAttribute("pegawai", pegawai);
        
        List<ProvinsiModel> listOfProvinsi = provinsiService.getAll();
        model.addAttribute("listOfProvinsi", listOfProvinsi);

        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfInstansi", listOfInstansi);

        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);

		return "addPegawai";
	}

    @RequestMapping(value="/pegawai/tambah", method=RequestMethod.POST)
    public String addPegawaiSubmit( @ModelAttribute PegawaiModel pegawai,
                                    Model model) {
        pegawaiService.addPegawai(pegawai);
        String response = String.format("Pegawai dengan NIP %s berhasil ditambahkan", pegawai.getNip());
        model.addAttribute("response", response);
        return "responsePage";
    }

    /////////////////////////////////////////////////////////////////////// FITUR 3
    @RequestMapping(value="/pegawai/ubah", method=RequestMethod.GET)
    public String editPegawai(@RequestParam(value="nip", required=true) String nip, Model model) {
        model.addAttribute("pegawai", pegawaiService.getPegawai(nip));
        
        List<ProvinsiModel> listOfProvinsi = provinsiService.getAll();
        model.addAttribute("listOfProvinsi", listOfProvinsi);

        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfInstansi", listOfInstansi);

        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);
        
        return "editPegawai";
    }

    @RequestMapping(value="/pegawai/ubah", method=RequestMethod.POST, params={"add-row"})
    public String editPegawaiSubmit(@ModelAttribute PegawaiModel pegawai,
                                    BindingResult bindingResult,
                                    Model model) {
        JabatanPegawaiModel newJabatan = new JabatanPegawaiModel();
        newJabatan.setPegawai(pegawai);
        pegawai.getJabatanPegawai().add(newJabatan);
        model.addAttribute("pegawai", pegawai);

        List<ProvinsiModel> listOfProvinsi = provinsiService.getAll();
        model.addAttribute("listOfProvinsi", listOfProvinsi);

        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfInstansi", listOfInstansi);

        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);

        return "editPegawai";
    }

    @RequestMapping(value="/pegawai/ubah", method=RequestMethod.POST)
    public String editPegawaiAddRow(@ModelAttribute PegawaiModel pegawai, Model model) {
        pegawaiService.updatePegawai(pegawai);
        String response = String.format("Pegawai dengan NIP %s berhasil diubah", pegawai.getNip());
        model.addAttribute("response", response);
        return "responsePage";
    }

    ///////////////////////////////////////////////////////////////////////// FITUR 4
    @RequestMapping(value="/pegawai/cari", method=RequestMethod.GET)
    public String findPegawaiSubmit(@RequestParam(value="idProvinsi", required=false) Long idProvinsi,
                                    @RequestParam(value="idInstansi", required=false) Long idInstansi,
                                    @RequestParam(value="idJabatan", required=false) Long idJabatan,
                                    Model model) {

        List<ProvinsiModel> listOfProvinsi = provinsiService.getAll();
        model.addAttribute("listOfProvinsi", listOfProvinsi);

        List<InstansiModel> listOfInstansi = instansiService.getAll();
        model.addAttribute("listOfInstansi", listOfInstansi);

        List<JabatanModel> listOfJabatan = jabatanService.getAll();
        model.addAttribute("listOfJabatan", listOfJabatan);
        
        List<PegawaiModel> result = new ArrayList<>();
        if      (idProvinsi != null && idInstansi == null) result = pegawaiService.getPegawaiByProvinsi( provinsiService.getProvinsi(idProvinsi) );
        else if (idProvinsi != null && idJabatan  != null) result = pegawaiService.getPegawaiByProvinsiAndJabatan( provinsiService.getProvinsi(idProvinsi), jabatanService.getJabatanById(idJabatan) );
        else if (idJabatan  != null && idInstansi == null) result = pegawaiService.getPegawaiByJabatan( jabatanService.getJabatanById(idJabatan) );
        else if (idJabatan  == null && idInstansi != null) result = pegawaiService.getPegawaiByInstansi( instansiService.getInstansi(idInstansi) );
        else if (idJabatan  != null && idInstansi != null) result = pegawaiService.getPegawaiByInstansiAndJabatan( instansiService.getInstansi(idInstansi), jabatanService.getJabatanById(idJabatan) );

        model.addAttribute("result", result);  
        return "findPegawai";   
    }

    ///////////////////////////////////////////////////////////////////////// FITUR 10
    @RequestMapping(value="/pegawai/termuda-tertua", method=RequestMethod.GET)
    public String youngestOldestPegawai(@RequestParam(value="idInstansi", required=true) long idInstansi, Model model) {
        model.addAttribute("youngest", pegawaiService.getYoungestPegawai(instansiService.getInstansi(idInstansi)));
        model.addAttribute("oldest", pegawaiService.getOldestPegawai(instansiService.getInstansi(idInstansi)));
        return "youngestOldestPegawai";
    }
}