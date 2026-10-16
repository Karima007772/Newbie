import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    private static final SingleLinkedList single = new SingleLinkedList();
    private static final DoubleLinkedList doubly = new DoubleLinkedList();
    private static final CircularLinkedList circular =
            new CircularLinkedList();

    public static void main(String[] args) {
        tampilanAwal();

        boolean berjalan = true;

        while (berjalan) {
            clearScreen();
            tampilkanMenu();

            int pilihan = bacaInt("Pilihan Anda: ", 0, 5);

            switch (pilihan) {
                case 1:
                    clearScreen();
                    tambahBarang();
                    break;

                case 2:
                    clearScreen();
                    System.out.println("=== DAFTAR INVENTORI BARANG ===");
                    single.tampil();
                    break;

                case 3:
                    clearScreen();
                    cariBarang();
                    break;

                case 4:
                    clearScreen();
                    updateStok();
                    break;

                case 5:
                    clearScreen();
                    hapusBarang();
                    break;

                case 0:
                    clearScreen();
                    System.out.println("========================================");
                    System.out.println("     TERIMA KASIH TELAH BERKUNJUNG");
                    System.out.println("========================================");
                    System.out.println("Program selesai.");
                    berjalan = false;
                    continue;
            }

            System.out.println();
            System.out.print("Tekan ENTER untuk kembali ke menu...");
            input.nextLine();
        }

        input.close();
    }

    // Membersihkan tampilan.
    private static void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    // Tampilan pembuka.
    private static void tampilanAwal() {
        System.out.println("========================================");
        System.out.println("              WELCOME TO");
        System.out.println();
        System.out.println("           TOKO SERBAGUNA");
        System.out.println("========================================");
        System.out.println(" Sistem Manajemen Inventori Barang");
        System.out.println(" Kelola barang dengan mudah dan teratur.");
        System.out.println("========================================");
        System.out.print("Tekan ENTER untuk memulai...");

        input.nextLine();
        clearScreen();
    }

    // Menu utama.
    private static void tampilkanMenu() {
        System.out.println("========================================");
        System.out.println("            TOKO SERBAGUNA");
        System.out.println("========================================");
        System.out.println("       SISTEM MANAJEMEN INVENTORI");
        System.out.println("----------------------------------------");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Lihat Semua Barang");
        System.out.println("3. Cari Barang");
        System.out.println("4. Update Stok");
        System.out.println("5. Hapus Barang");
        System.out.println("0. Keluar");
        System.out.println("========================================");
    }

    // Tambah barang.
    private static void tambahBarang() {
        System.out.println("=== TAMBAH BARANG ===");

        String kode = bacaString("Kode barang: ");

        if (single.cari(kode) != null) {
            System.out.println("Kode barang sudah digunakan.");
            return;
        }

        String nama = bacaString("Nama barang: ");
        double harga = bacaDouble("Harga barang: ", 0);
        int stok = bacaInt("Stok awal: ", 0, Integer.MAX_VALUE);

        System.out.println("\nPilih kategori:");
        System.out.println("1. Elektronik");
        System.out.println("2. ATK");
        System.out.println("3. Perlengkapan Rumah Tangga");

        int kategori = bacaInt("Kategori: ", 1, 3);
        Barang barang;

        try {
            switch (kategori) {
                case 1:
                    barang = new Elektronik(
                            kode, nama, harga, stok);
                    break;

                case 2:
                    String jenis = bacaString("Jenis ATK: ");
                    barang = new ATK(
                            kode, nama, harga, stok, jenis);
                    break;

                default:
                    String bahan = bacaString("Bahan barang: ");
                    barang = new PerlengkapanRumahTangga(
                            kode, nama, harga, stok, bahan);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Gagal membuat barang: " + e.getMessage());
            return;
        }

        single.tambah(barang);
        doubly.tambah(barang);
        circular.tambah(barang);

        System.out.println("\nBarang berhasil ditambahkan!");
        System.out.println("Status stok: " + barang.getStatusStok());
    }

    // Cari barang.
    private static void cariBarang() {
        System.out.println("=== CARI BARANG ===");

        String kode = bacaString("Masukkan kode barang: ");
        Barang barang = single.cari(kode);

        if (barang == null) {
            System.out.println("Barang tidak ditemukan.");
        } else {
            System.out.println("\nBarang ditemukan:");
            barang.tampilkanInfo();
        }
    }

    // Update stok.
    private static void updateStok() {
        System.out.println("=== UPDATE STOK ===");

        String kode = bacaString("Masukkan kode barang: ");
        Barang barang = single.cari(kode);

        if (barang == null) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }

        System.out.println("Nama barang    : " + barang.getNamaBarang());
        System.out.println("Stok saat ini  : " + barang.getStok());
        System.out.println("Status saat ini: " + barang.getStatusStok());

        int stokBaru = bacaInt(
                "Masukkan stok baru: ", 0, Integer.MAX_VALUE);

        single.updateStok(kode, stokBaru);
        doubly.updateStok(kode, stokBaru);
        circular.updateStok(kode, stokBaru);

        System.out.println("\nStok berhasil diperbarui!");
        System.out.println("Stok sekarang: " + barang.getStok());
        System.out.println("Status baru  : " + barang.getStatusStok());
    }

    // Hapus barang.
    private static void hapusBarang() {
        System.out.println("=== HAPUS BARANG ===");

        String kode = bacaString("Masukkan kode barang: ");
        Barang barang = single.cari(kode);

        if (barang == null) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }

        single.hapus(kode);
        doubly.hapus(kode);
        circular.hapus(kode);

        System.out.println("Barang " + kode + " berhasil dihapus.");
    }

    // Input teks.
    private static String bacaString(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            if (!nilai.isEmpty()) {
                return nilai;
            }

            System.out.println("Input tidak boleh kosong.");
        }
    }

    // Input bilangan bulat.
    private static int bacaInt(
            String pesan, int minimum, int maksimum) {

        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            try {
                int angka = Integer.parseInt(nilai);

                if (angka >= minimum && angka <= maksimum) {
                    return angka;
                }

                System.out.println(
                        "Masukkan angka dari " + minimum
                        + " sampai " + maksimum + ".");
            } catch (NumberFormatException e) {
                System.out.println(
                        "Input harus berupa bilangan bulat.");
            }
        }
    }

    // Input harga.
    private static double bacaDouble(
            String pesan, double minimum) {

        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            try {
                double angka = Double.parseDouble(nilai);

                if (Double.isFinite(angka) && angka >= minimum) {
                    return angka;
                }

                System.out.println(
                        "Masukkan angka yang valid dan tidak negatif.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }
}