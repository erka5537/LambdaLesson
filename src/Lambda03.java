import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAsı", "waffle", "künefe"));


        /* Task -1 */ alfBykTekrsz(menu);                System.out.println();

        /* Task -2 */ chrSayisiTersSiraliUnique(menu);   System.out.println();

        /* Task -3 */ chrSayisiBykSirali(menu);          System.out.println();

        /* Task -4 */ harfSayisi7denAzKontrol(menu);     System.out.println();

        /* Task -5 */ wIlebaslayanElKontrol(menu);       System.out.println();

        /* Task -6 */ xIleBitenElKontrol(menu);          System.out.println();

        /* Task -7 */ chrSayisiEnBuyukElPrint(menu);     System.out.println();

        /* Task -8 */ chrSayisiSonElPrint(menu);         System.out.println();


    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> yemek){

        yemek.
                stream(). //akış başladı
                map(String::toUpperCase). // Büyük harf şartı karşılandı
                sorted().// doğal sıralama (alfabetik)
                distinct(). // elemanların tekrarsız olmasını sağladı
                forEach(t-> System.out.print(t+" ")); // print

    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSiraliUnique(List<String> yemek){

        yemek.
                stream(). // akış alındı
                map(String::length). // akışı güncelledim, kelimelerin uzunluğu olarak
                sorted(Comparator.reverseOrder()).  //tersten sıraladım
                distinct().// tekrarsız hale getirdim
                forEach(Lambda01::yazdir);  //yazdırdım
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBykSirali(List<String> yemek){
        yemek.
                stream(). // akış sağlandı
                sorted(Comparator.comparing(String::length)). // String ifadeleri karakter sayısına göre sıraladım
                forEach(Lambda01::yazdir);// print
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> yemek){
        System.out.println(yemek.stream().allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harfden oluşuyor" :
                "list elemanlarından herhangi biri 7 harften büyük");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIlebaslayanElKontrol(List<String> yemek){
        System.out.println(yemek.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yok" :
                "w ile yemek var");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> yemek){
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten yemek var" :
                "x ile biten yemek yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void chrSayisiEnBuyukElPrint(List<String> yemek){

        Stream<String> sonIsim = yemek.
                stream().// akış sağlandı
                        sorted(Comparator.comparing(String::length).
                        reversed()).// karakter sayısına göre tersten sıralandı
                        limit(1);// limit metodu kullanılarak sadece ilk eleman çağrıldı

        System.out.println(Arrays.toString(sonIsim.toArray()));
        //sonIsim.toArray() --> Stream olan akış Array'e çevrildi
        // Arrays.toString(sonIsim.toArray()) --> Arrayı string yapıya çeviriyor
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void chrSayisiSonElPrint(List<String> yemek){
        yemek.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfine göre alfabetik sıralandı
                skip(1). // akışdaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir); // ekrana print edildi
    }
}
