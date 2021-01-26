package Latihan4;

import java.util.ArrayList;

public class Mahasiswa {
    private int idMahasiswa;
    private String nama;
    ArrayList<Nilai> nilai = new ArrayList<>();

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Nilai> getNilai() {
        return nilai;
    }

    public void setNilai(Nilai nilai) {
        this.nilai.add(nilai);
    }
}
