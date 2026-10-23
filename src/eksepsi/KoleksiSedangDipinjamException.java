
package eksepsi;

public class KoleksiSedangDipinjamException
        extends PustakaException {

    public KoleksiSedangDipinjamException(String judul) {
        super("Koleksi \"" + judul
                + "\" sedang dipinjam orang lain.");
    }
}
