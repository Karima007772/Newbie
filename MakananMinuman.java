public class MakananMinuman extends Barang {
    private String kadaluarsa;

    public MakananMinuman(String kodeBarang, String namaBarang, double harga, int stok, String kadaluarsa) {
        super(kodeBarang, namaBarang, harga, stok);
        this.kadaluarsa = kadaluarsa;
    }

    public String getKadaluarsa() {
        return kadaluarsa;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[MAKANAN/MINUMAN] Kode: " + kodeBarang + " | Nama: " + namaBarang + 
                           " | Harga: Rp " + harga + " | Stok: " + stok + " | Exp: " + kadaluarsa);
    }
}