public interface ListADT {
    void tambah(Barang barang);

    Barang cari(String kodeBarang);

    boolean hapus(String kodeBarang);

    boolean updateStok(String kodeBarang, int stokBaru);

    void tampil();
}