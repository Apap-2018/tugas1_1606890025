package com.apap.tugas1.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name="nama_jabatan", nullable=false)
    private String namaJabatan;

    @NotNull
    @Size(max=255)
    @Column(name="deskripsi_jabatan", nullable=false)
    private String deskripsiJabatan;

    @NotNull
    @Column(name="gaji_pokok")
    private Double gajiPokok;

}