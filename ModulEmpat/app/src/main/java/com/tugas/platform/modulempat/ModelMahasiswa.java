package com.tugas.platform.modulempat;

public class ModelMahasiswa {
    private int img;
    private String nama, nim;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public ModelMahasiswa(int img, String nama, String nim) {
        this.img = img;
        this.nama = nama;
        this.nim = nim;
    }
}
