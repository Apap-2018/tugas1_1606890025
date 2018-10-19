package com.apap.tugas1.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="jabatan")
public class JabatanModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max=255)
    @Column(name="nama", nullable=false)
    private String nama;

    @NotNull
    @Size(max=255)
    @Column(name="deskripsi", nullable=false)
    private String deskripsi;

    @NotNull
    @Column(name="gaji_pokok")
    private Double gajiPokok;

    @OneToMany(mappedBy="jabatan", cascade=CascadeType.PERSIST)
    private Set<JabatanPegawaiModel> jabatanPegawai;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getGajiPokok() {
        return this.gajiPokok;
    }

    public void setGajiPokok(Double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public Set<JabatanPegawaiModel> getJabatanPegawai() {
        return this.jabatanPegawai;
    }

    public void setJabatanPegawai(Set<JabatanPegawaiModel> jabatanPegawai) {
        this.jabatanPegawai = jabatanPegawai;
    }

}