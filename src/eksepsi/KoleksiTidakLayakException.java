
package eksepsi;

public class KoleksiTidakLayakException
        extends PustakaException {

    public KoleksiTidakLayakException(String judul) {
        super("Koleksi \"" + judul
                + "\" belum layak dipinjam saat ini.");
    }
}
