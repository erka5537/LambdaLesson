import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println();
        ciftKarekok(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        structuredMaxElBul(sayi);
        System.out.println();
        ciftKareBuyukPrint(sayi);
        System.out.println();
        toplamiBul(sayi);
        System.out.println();
        ciftCarp(sayi);
        System.out.println();
        minElBul(sayi);
        System.out.println();
        tekbes(sayi);
        System.out.println();
        ciftKareKbSortPrint(sayi);

    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).// akışdaki çift sayıları filtreledim
                map(t-> t*t).// 16, 4, 36 -- Stream içersindeki elemanları başka değerlere dönüştürür
                forEach(Lambda01::yazdir);
    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edin
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2!=0).
                map(t-> (t*t*t)+1).
                forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekok(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).forEach(t -> System.out.println(t + " "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi){

        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); //eğer benim result'um tek bir değr ise o zaman reduce terminal oparatör kullanılır
        System.out.println(maxSayi);
    }

    // Structured yapı ile çözelim
    public static void structuredMaxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<sayi.size(); i++){
            max = Math.max(max, sayi.get(i));
        }
        System.out.println(max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareBuyukPrint(List<Integer> sayi){
        Optional<Integer> ciftBuyuk = sayi.
                stream().
                filter(Lambda01::ciftBul).// akışdaki çift sayıları filtreledim
                map(t-> t*t).reduce(Integer::max); //Math::max ' a göre daha hızlı çalışır..
        System.out.printf("%s",ciftBuyuk);
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void toplamiBul(List<Integer> sayi){
        int toplam = sayi.stream()
                .reduce(0, (a,b) -> a+b);
        System.out.println(toplam);
        /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır

        */
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //method referance

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b));//lambda exression
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minElBul(List<Integer> sayi){
//1.Yol: method referance
        Optional<Integer> minSayi = sayi.
                stream().
                reduce(Integer::min); //Math::min
        System.out.println(minSayi);
//2.Yol: method referance
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a, int b){
        return a<b ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void tekbes(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(t -> t % 2 != 0 && t > 5).reduce(Integer::min));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbSortPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).// akışdaki çift sayıları filtreledim
                map(t-> t*t). //sayıların karesi ile yeni bir akış oluşturdum
                sorted().// akış içindeki sayıları naturel-order olarak sıraladım
                forEach(Lambda01::yazdir);// akışdaki sayıları ekrana yazdım
    }
}
