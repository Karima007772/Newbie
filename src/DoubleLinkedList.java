public class DoubleLinkedList implements ListADT {
    private DoubleNode head;
    private DoubleNode tail;

    @Override
    public void tambah(Barang barang) {
        DoubleNode baru = new DoubleNode(barang);

        if (head == null) {
            head = tail = baru;
            return;
        }

        tail.next = baru;
        baru.prev = tail;
        tail = baru;
    }

    @Override
    public Barang cari(String kodeBarang) {
        DoubleNode temp = head;

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
        DoubleNode temp = head;

        while (temp != null) {
            if (temp.data.getKodeBarang()
                    .equalsIgnoreCase(kodeBarang)) {

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

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

        DoubleNode temp = head;
        int nomor = 1;

        while (temp != null) {
            System.out.println("\n--- Barang ke-" + nomor + " ---");
            temp.data.tampilkanInfo();
            temp = temp.next;
            nomor++;
        }
    }
}