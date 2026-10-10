public abstract class Barang {
    protected String kodeBarang;
    protected String namaBarang;
    protected double harga;
    protected int stok;

    public Barang(String kodeBarang, String namaBarang, double harga, int stok) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Abstract method yang wajib dioverride oleh subclass
    public abstract void tampilkanInfo();
}