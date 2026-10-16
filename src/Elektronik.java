
public class Elektronik extends Barang {

    public Elektronik(String kodeBarang, String namaBarang,
                      double harga, int stok) {
        super(kodeBarang, namaBarang, harga, stok);
    }

    @Override
    public String getKategori() {
        return "Elektronik";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kode     : " + getKodeBarang());
        System.out.println("Nama     : " + getNamaBarang());
        System.out.println("Kategori : " + getKategori());
        System.out.printf("Harga    : Rp%.2f%n", getHarga());
        System.out.println("Stok     : " + getStok());
        System.out.println("Status   : " + getStatusStok());
    }
}