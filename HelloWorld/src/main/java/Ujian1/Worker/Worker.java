package Ujian1.Worker;

import Ujian1.Ujian1;

public abstract class Worker {
    private int id;
    private String nama;


    private int gajiPokok;

    public int getAbsensi() {
        return absensi;
    }

    private int absensi, cuti, izin;
    private int jumlahCuti;
    private int jumlahIzin;

    public Worker() {

    }

    public abstract void setAbsen();

    public abstract void setCuti();

    public abstract void setIzin();

    public Worker(int id, String nama, int gajiPokok, int absensi, int cuti, int izin, int jumlahCuti, int jumlahIzin) {
        this.id = id;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
        this.absensi = absensi;
        this.cuti = cuti;
        this.izin = izin;
        this.jumlahCuti = jumlahCuti;
        this.jumlahIzin = jumlahIzin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getGajiPokok() {
            return gajiPokok;
    }
    public int hitungGajiPokok(){
        return gajiPokok/22;
    }

    public int getJumlahCuti() {
        return jumlahCuti;
    }

    public void setJumlahCuti(int jumlahCuti) {
        this.jumlahCuti = jumlahCuti;
    }

    public int getJumlahIzin() {
        return jumlahIzin;
    }

    public void setJumlahIzin(int jumlahIzin) {
        this.jumlahIzin = jumlahIzin;
    }


}
