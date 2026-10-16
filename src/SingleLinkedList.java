public class SingleLinkedList implements ListADT {
    private Node head;

    @Override
    public void tambah(Barang barang) {
        Node baru = new Node(barang);

        if (head == null) {
            head = baru;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = baru;
    }

    @Override
    public Barang cari(String kodeBarang) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.getKodeBarang()
                    .equalsIgnoreCase(kodeBarang)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean hapus(String kodeBarang) {
        if (head == null) {
            return false;
        }

        if (head.data.getKodeBarang()
                .equalsIgnoreCase(kodeBarang)) {
            head = head.next;
            return true;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.getKodeBarang()
                    .equalsIgnoreCase(kodeBarang)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean updateStok(String kodeBarang, int stokBaru) {
        Barang barang = cari(kodeBarang);

        if (barang == null || stokBaru < 0) {
            return false;
        }

        barang.setStok(stokBaru);
        return true;
    }

    @Override
    public void tampil() {
        if (head == null) {
            System.out.println("Inventori masih kosong.");
            return;
        }

        Node temp = head;
        int nomor = 1;

        while (temp != null) {
            System.out.println("\n--- Barang ke-" + nomor + " ---");
            temp.data.tampilkanInfo();
            temp = temp.next;
            nomor++;
        }
    }
}