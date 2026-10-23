
package layanan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Koleksi;
import eksepsi.*;

public class KatalogPerpustakaan {

    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambahKoleksi(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return new ArrayList<>(daftar);
    }

    // Menampilkan status seluruh koleksi secara polimorfik.
    public void cetakStatus() {
        System.out.printf(
                "%-8s %-32s %-15s%n",
                "KODE", "JUDUL", "STATUS"
        );

        System.out.println("-".repeat(58));

        for (Koleksi koleksi : daftar) {
            System.out.printf(
                    "%-8s %-32s %-15s%n",
                    koleksi.getKodeKoleksi(),
                    koleksi.getJudul(),
                    koleksi.getStatus()
            );
        }
    }

    // Aturan pengurutan dapat ditentukan dari luar.
    public void urut(Comparator<Koleksi> pembanding) {
        Collections.sort(daftar, pembanding);
    }

    // Memproses peminjaman dan melempar exception yang sesuai.
    public void pinjam(String kodeKoleksi)
            throws PustakaException {

        for (Koleksi koleksi : daftar) {
            if (koleksi.getKodeKoleksi().equalsIgnoreCase(
                    kodeKoleksi)) {

                if (koleksi.isSedangDipinjam()) {
                    throw new KoleksiSedangDipinjamException(
                            koleksi.getJudul()
                    );
                }

                if (!koleksi.layakDipinjam()) {
                    throw new KoleksiTidakLayakException(
                            koleksi.getJudul()
                    );
                }

                koleksi.setSedangDipinjam(true);

                System.out.println(
                        "Berhasil meminjam: "
                        + koleksi.getJudul()
                );
                return;
            }
        }

        throw new PustakaException(
                "Kode koleksi " + kodeKoleksi
                + " tidak ditemukan dalam katalog."
        );
    }
}
