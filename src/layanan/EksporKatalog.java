
package layanan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import model.Koleksi;

public class EksporKatalog {

    public void ekspor(
            String namaBerkas,
            List<Koleksi> daftar
    ) throws IOException {

        try (PrintWriter tulis = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(namaBerkas)))) {

            tulis.println("KATALOG KOLEKSI PERPUSTAKAAN");
            tulis.println("Tanggal cetak: " + LocalDate.now());
            tulis.println();

            tulis.printf(
                    "%-10s %-34s %-10s %-18s%n",
                    "KODE", "JUDUL", "TAHUN", "STATUS"
            );

            tulis.println("-".repeat(74));

            for (Koleksi koleksi : daftar) {
                tulis.printf(
                        "%-10s %-34s %-10d %-18s%n",
                        koleksi.getKodeKoleksi(),
                        koleksi.getJudul(),
                        koleksi.getTahunTerbit(),
                        koleksi.getStatus()
                );
            }

            tulis.println();
            tulis.println("Jumlah koleksi: " + daftar.size());
        }
    }
}
