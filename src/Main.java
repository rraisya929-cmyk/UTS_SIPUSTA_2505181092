
import java.util.List;

import model.*;
import layanan.*;
import eksepsi.PustakaException;

public class Main {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog =
                new KatalogPerpustakaan();

        katalog.tambahKoleksi(
                new BukuCetak(
                        "BK-001", "Java How to Program",
                        2022, 620, "A-12",
                        "Lantai 1", false
                )
        );

        katalog.tambahKoleksi(
                new BukuCetak(
                        "BK-002", "Basis Data Relasional",
                        2021, 410, "B-04",
                        "Lantai 1", true
                )
        );

        katalog.tambahKoleksi(
                new Majalah(
                        "MJ-001", "Info Teknologi Edisi 88",
                        2026, 88, "Agustus", true,
                        "M-01", "Lantai 2"
                )
        );

        katalog.tambahKoleksi(
                new Majalah(
                        "MJ-002", "Info Teknologi Edisi 87",
                        2026, 87, "Juli", false,
                        "M-02", "Lantai 2"
                )
        );

        katalog.tambahKoleksi(
                new BerkasDigital(
                        "BD-001", "Panduan Pemrograman Java",
                        2024, 15,
                        "unduh.polmed.ac.id/bd001"
                )
        );

        katalog.tambahKoleksi(
                new BerkasDigital(
                        "BD-002", "Jurnal Rekayasa Perangkat",
                        2025, 8,
                        "unduh.polmed.ac.id/bd002"
                )
        );

        System.out.println("=== STATUS KOLEKSI ===");
        katalog.cetakStatus();

        System.out.println("\n=== UJI PEMINJAMAN ===");

        try {
            katalog.pinjam("BK-001");
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam("XX-999");
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        System.out.println("\n=== SETELAH DIURUTKAN ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== EKSPOR KATALOG ===");

        EksporKatalog ekspor = new EksporKatalog();

        try {
            List<Koleksi> daftar = katalog.getDaftar();
            ekspor.ekspor("katalog.txt", daftar);

            System.out.println(
                    "Katalog berhasil disimpan ke katalog.txt"
            );
        } catch (java.io.IOException e) {
            System.out.println(
                    "Gagal menulis katalog: " + e.getMessage()
            );
        }
    }
}
