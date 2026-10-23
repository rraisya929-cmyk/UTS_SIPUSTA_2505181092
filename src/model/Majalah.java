
package model;

public class Majalah extends Koleksi implements Terarsip {

    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String rak;
    private String lantai;

    public Majalah(
            String kodeKoleksi,
            String judul,
            int tahunTerbit,
            int edisi,
            String bulanTerbit,
            boolean edisiTerbaru,
            String rak,
            String lantai
    ) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.rak = rak;
        this.lantai = lantai;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + ", Edisi: " + edisi
                + ", Bulan: " + bulanTerbit
                + ", " + ringkasanArsip();
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
