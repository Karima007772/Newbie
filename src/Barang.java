public abstract class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int stok;

    public Barang(String kodeBarang, String namaBarang,
                  double harga, int stok) {
        if (kodeBarang == null || kodeBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode barang tidak boleh kosong.");
        }
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        if (harga < 0 || stok < 0) {
            throw new IllegalArgumentException("Harga dan stok tidak boleh negatif.");
        }

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

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif.");
        }
        this.stok = stok;
    }

    public String getStatusStok() {
        if (stok == 0) {
            return "Habis";
        } else if (stok <= 5) {
            return "Stok menipis";
        }
        return "Tersedia";
    }

    public abstract String getKategori();

    public abstract void tampilkanInfo();
}