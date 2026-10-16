public class CircularLinkedList implements ListADT {
    private Node head;
    private Node tail;

    @Override
    public void tambah(Barang barang) {
        Node baru = new Node(barang);

        if (head == null) {
            head = tail = baru;
            tail.next = head;
            return;
        }

        tail.next = baru;
        tail = baru;
        tail.next = head;
    }

    @Override
    public Barang cari(String kodeBarang) {
        if (head == null) {
            return null;
        }

        Node temp = head;

        do {
            if (temp.data.getKodeBarang()
                    .equalsIgnoreCase(kodeBarang)) {
                return temp.data;
            }
            temp = temp.next;
        } while (temp != head);

        return null;
    }

    @Override
    public boolean hapus(String kodeBarang) {
        if (head == null) {
            return false;
        }

        Node sekarang = head;
        Node sebelumnya = tail;

        do {
            if (sekarang.data.getKodeBarang()
                    .equalsIgnoreCase(kodeBarang)) {

                // Hanya ada satu node.
                if (head == tail) {
                    head = tail = null;
                    return true;
                }

                // Menghapus head.
                if (sekarang == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    sebelumnya.next = sekarang.next;

                    // Menghapus tail.
                    if (sekarang == tail) {
                        tail = sebelumnya;
                        tail.next = head;
                    }
                }

                return true;
            }

            sebelumnya = sekarang;
            sekarang = sekarang.next;
        } while (sekarang != head);

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

        do {
            System.out.println("\n--- Barang ke-" + nomor + " ---");
            temp.data.tampilkanInfo();
            temp = temp.next;
            nomor++;
        } while (temp != head);
    }
}