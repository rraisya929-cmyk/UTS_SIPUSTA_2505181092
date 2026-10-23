
package model;

public class BukuCetak extends Koleksi implements Terarsip {

    private int jumlahHalaman;
    private String rak;
    private String lantai;
    private boolean sedangDiperbaiki;

    public BukuCetak(
            String kodeKoleksi,
            String judul,
            int tahunTerbit,
            int jumlahHalaman,
            String rak,
            String lantai,
            boolean sedangDiperbaiki
    ) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.rak = rak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + ", Halaman: " + jumlahHalaman
                + ", " + ringkasanArsip()
                + ", Diperbaiki: "
                + (sedangDiperbaiki ? "Ya" : "Tidak");
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }
}
