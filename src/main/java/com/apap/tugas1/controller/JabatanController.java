package com.apap.tugas1.controller;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.JabatanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JabatanController {
    @Autowired private JabatanService jabatanService;

    // FITUR 5
    @RequestMapping(value="/jabatan/tambah", method=RequestMethod.GET)
    public String addJabatan(Model model) {
        return "addJabatan";
    }

    @RequestMapping(value="/jabatan/tambah", method=RequestMethod.POST)
    public String addJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
        jabatanService.addJabatan(jabatan);
        model.addAttribute("jabatan", jabatan);
        return "responsePage";
    }

    // FITUR 6
    @RequestMapping(value="/jabatan/view", method=RequestMethod.GET)
    public String viewJabatan(@RequestParam(value="idJabatan", required=true) long idJabatan, Model model) {
        JabatanModel jabatan = jabatanService.getJabatanById(idJabatan);
        model.addAttribute("jabatan", jabatan);
        return "getJabatan";
    }

    // FITUR 7
    @RequestMapping(value="/jabatan/ubah", method=RequestMethod.GET)
    public String editJabatan(@RequestParam(value="idJabatan", required=true) long idJabatan, Model model) {
        model.addAttribute("jabatan", jabatanService.getJabatanById(idJabatan));
        return "editJabatan";
    }

    @RequestMapping(value="/jabatan/ubah", method=RequestMethod.POST)
    public String editJabatanSubmit(@ModelAttribute JabatanModel jabatan,
                                    Model model) {
        return "editJabatan";
    }

    // FITUR 8
    @RequestMapping(value="/jabatan/hapus", method=RequestMethod.POST)
    public String removeJabatan(@ModelAttribute JabatanModel jabatan, Model model) {
        boolean isSuceed = jabatanService.removeJabatan(jabatan);
        model.addAttribute("response", isSuceed);
        // todo true false delete
        return "responsePage";
    }
        
    // FITUR 9
    @RequestMapping(value="/jabatan/viewall", method=RequestMethod.GET)
    public String viewAllJabatan(Model model) {
        model.addAttribute("listOfJabatan", jabatanService.getAll());
        return "viewAllJabatan";
    }

    @RequestMapping(value="/jabatan/data")
    public List<JabatanModel> dataJabatan(Model model) {
        return jabatanService.getAll();
    }

}