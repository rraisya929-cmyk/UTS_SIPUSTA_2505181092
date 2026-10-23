
package model;

public abstract class Koleksi {

    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
    protected boolean sedangDipinjam;

    public Koleksi(
            String kodeKoleksi,
            String judul,
            int tahunTerbit
    ) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public abstract boolean layakDipinjam();

    public String deskripsi() {
        return kodeKoleksi + " - " + judul
                + " (" + tahunTerbit + ")";
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }

    public String getStatus() {
        if (sedangDipinjam) {
            return "Dipinjam";
        }

        if (!layakDipinjam()) {
            return "Tidak layak";
        }

        return "Tersedia";
    }
}
