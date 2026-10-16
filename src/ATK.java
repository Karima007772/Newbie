public class ATK extends Barang {
    private String jenisATK;

    public ATK(String kodeBarang, String namaBarang,
               double harga, int stok, String jenisATK) {
        super(kodeBarang, namaBarang, harga, stok);

        if (jenisATK == null || jenisATK.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Jenis ATK tidak boleh kosong."
            );
        }
        this.jenisATK = jenisATK;
    }

    public String getJenisATK() {
        return jenisATK;
    }

    @Override
    public String getKategori() {
        return "ATK";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kode      : " + getKodeBarang());
        System.out.println("Nama      : " + getNamaBarang());
        System.out.println("Kategori  : " + getKategori());
        System.out.printf("Harga     : Rp%.2f%n", getHarga());
        System.out.println("Stok      : " + getStok());
        System.out.println("Status    : " + getStatusStok());
        System.out.println("Jenis ATK : " + jenisATK);
    }
}