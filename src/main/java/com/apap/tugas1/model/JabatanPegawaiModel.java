package com.apap.tugas1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // source https://hellokoding.com/jpa-many-to-many-extra-columns-relationship-mapping-example-with-spring-boot-maven-and-mysql/
    @ManyToOne
    @JoinColumn(name="id_pegawai", referencedColumnName="id")
    private PegawaiModel pegawai;

    @ManyToOne
    @JoinColumn(name="id_jabatan", referencedColumnName="id")
    private JabatanModel jabatan;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PegawaiModel getPegawai() {
        return this.pegawai;
    }

    public void setPegawai(PegawaiModel pegawai) {
        this.pegawai = pegawai;
    }

    public JabatanModel getJabatan() {
        return this.jabatan;
    }

    public void setJabatan(JabatanModel jabatan) {
        this.jabatan = jabatan;
    }

    public String stringJabatan() {
        return this.jabatan.getNama();
    }

    public String stringPegawai() {
        return this.pegawai.getNama();
    }
}