public class Universite {
    /*
        Pojo(Plain Old Java Object) Class nedir
        1)Variable ları private olan (Encapsulation yapılmış olan)
        2)Bir parametresiz birde parametreli Constructor olan
        3)Getter ve Setter methodlar olan
        4)toString() methodu olan
        Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
    */

    private String univercity;
    private String bolum;
    private int ogrSayisi;
    private int notOrt;

    // parametresiz const.
    public Universite() {
    }

    // parametreli const.
    public Universite(String univercity, String bolum, int ogrSayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
