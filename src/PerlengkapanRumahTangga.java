public class PerlengkapanRumahTangga extends Barang {
    private String bahan;

    public PerlengkapanRumahTangga(
            String kodeBarang, String namaBarang,
            double harga, int stok, String bahan) {
        super(kodeBarang, namaBarang, harga, stok);

        if (bahan == null || bahan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Bahan tidak boleh kosong."
            );
        }
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }

    @Override
    public String getKategori() {
        return "Perlengkapan Rumah Tangga";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kode      : " + getKodeBarang());
        System.out.println("Nama      : " + getNamaBarang());
        System.out.println("Kategori  : " + getKategori());
        System.out.printf("Harga     : Rp%.2f%n", getHarga());
        System.out.println("Stok      : " + getStok());
        System.out.println("Status    : " + getStatusStok());
        System.out.println("Bahan     : " + bahan);
    }
}