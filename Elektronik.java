public class Elektronik extends Barang {
    private int garansi; // dalam bulan

    public Elektronik(String kodeBarang, String namaBarang, double harga, int stok, int garansi) {
        super(kodeBarang, namaBarang, harga, stok);
        this.garansi = garansi;
    }

    public int getGaransi() {
        return garansi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[ELEKTRONIK]     Kode: " + kodeBarang + " | Nama: " + namaBarang + 
                           " | Harga: Rp " + harga + " | Stok: " + stok + " | Garansi: " + garansi + " bulan");
    }
}