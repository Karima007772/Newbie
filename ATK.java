public class ATK extends Barang {
    private String jenisBahan;

    public ATK(String kodeBarang, String namaBarang, double harga, int stok, String jenisBahan) {
        super(kodeBarang, namaBarang, harga, stok);
        this.jenisBahan = jenisBahan;
    }

    public String getJenisBahan() {
        return jenisBahan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[ATK]            Kode: ` + kodeBarang + ` | Nama: " + namaBarang + 
                           " | Harga: Rp " + harga + " | Stok: " + stok + " | Bahan/Tipe: " + jenisBahan);
    }
}