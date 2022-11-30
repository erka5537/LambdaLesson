package lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        /* Soru - 1 */      System.out.println(ilkHarfBykGerisiKckList(list));

        /* Soru - 2 */      System.out.println(ecIleBaslayanList(list));

        /* Soru - 3 */      yildizIleYaz(list);                 System.out.println();

        /* Soru - 4 */      System.out.println(eOlanList(list));

        /* Soru - 5 */      lLeriSil(list);                     System.out.println();

        /* Soru - 6 */      ilkHarfSiraIlk5elChEnbyk(list);     System.out.println();
    }

    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static List<String> ilkHarfBykGerisiKckList(List<String> list){
        return list.stream().
                map(t->t.substring(0,1).
                toUpperCase()+t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ecIleBaslayanList(List<String> list){
        return list.stream().
                filter(t->t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizIleYaz(List<String> list){
         list.stream().
                map(t-> "*" + t + "*").
                forEach(Utils::yazString);
    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanList(List<String> list){
        return list.stream().
                filter(t->t.toLowerCase().contains("e")).
                collect(Collectors.toList());
    }

    //S5: tum 'l' leri silelim yazdiralim
    public static void lLeriSil(List<String> list){
        list.stream().
                map(t-> t.replace("l","")).
                forEach(Utils::yazString);
    }

    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void ilkHarfSiraIlk5elChEnbyk(List<String> list){
        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).//list elemanlarını ikinci harfe göre sıraladım
                limit(5).// ilk 5 eleman akışa devam etti
                sorted(Comparator.comparing(String::length).// ilk 5 elemanı char sayısına göre sıraladım
                reversed()).//sıralamayı tersine çevirdim
                findFirst());// akıştakı ilk elemanı aldım
    }
}
