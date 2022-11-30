import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

        /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi muh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        /* Task -1 */           System.out.println(notOrt74BykUnv(unv));

        /* Task -2 */           System.out.println(matBolumVarMi(unv));

        /* Task -3 */           System.out.println(ogrSayisiBykSirala(unv));

        /* Task -4 */           System.out.println(matBolumSayisi(unv));

        /* Task -5 */           System.out.println(ogrSayisi550BykMaxNotOrt(unv));

        /* Task -6 */           System.out.println(ogrSayisi1050KckMinNotOrt(unv));
    }

    //task 01--> bütün ünv. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().
                anyMatch(t->t.getBolum().
                        equalsIgnoreCase("matematik")); //veya --> contains("mat")
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv){
        return unv.
                stream(). //akış sağlanı
                sorted(Comparator.comparing(Universite::getOgrSayisi).// üniversiteler öğrenci sayısına göre sıralandı
                reversed()).// sıralama tersine çevrildi
                collect(Collectors.toList()); // stream yapısı list yapısına dönüştü
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
        return (int) unv.
                stream(). //akışı sağladım
                filter(t->t.getBolum().equalsIgnoreCase("matematik")). // matematik bölümü olan ünv. seçtim
                count(); // seçilen unv. sayısını aldım
    }

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi550BykMaxNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(Universite::getNotOrt).//veya t->t.getNotOrt()
                max();
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi1050KckMinNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(Universite::getNotOrt).//veya t->t.getNotOrt()
                min();
    }
}
