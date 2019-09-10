package com.joshua.entity;

public class Barang {
    private String nama;
    private Category category;
    private double harga;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCategory() {
        return category.getCatName();
    }

    public void setCategory(String category) {
        //this.category =
    }

    public String getHarga() {
        return String.valueOf(harga);
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
