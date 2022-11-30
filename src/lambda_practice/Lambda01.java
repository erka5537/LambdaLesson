package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list);
        System.out.println();
        negatifYaz(list);
        System.out.println();
        ciftYaz(list);
        System.out.println();
        pozVeCift(list);
        System.out.println();
        pozVeyaCift(list);
        System.out.println();
        listElKare(list);
        System.out.println();
        ciftKupYazdir(list);
        System.out.println();
        listElKareTekrarsiz(list);
        System.out.println();
        kucuktenBuyuge(list);
        System.out.println();
        buyuktenKucuge(list);
        System.out.println();
        System.out.println(pozKup5kck(list));
        System.out.println();
        System.out.println(pozKare5kckdegil(list));
        System.out.println();
        toplamiBul(list);
        System.out.println();
        toplamiBul2(list);
        System.out.println();
        toplamiBulPoz(list);
    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYazdir(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t + " "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> list){
        list.stream().filter(t->t<0).forEach(t-> System.out.print(t + " "));
    }

    //S3: çift olanlardan yeni bir liste olustur
    public static void ciftYaz(List<Integer> list){
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t + " "));
    }

    //pozitif ve çift olanları yazdırın
    public static void pozVeCift(List<Integer> list){
        list.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t + " "));
    }

    //pozitif veya çift olanları yazdırın
    public static void pozVeyaCift(List<Integer> list){
        list.stream().filter(t->t%2==0 || t>0).forEach(t-> System.out.print(t + " "));
    }

    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
    //ıslem yapmak ıcın (update) kullanılır
    public static void listElKare(List<Integer> list){
        list.stream().map(t->t*t).forEach(t-> System.out.print(t + " "));
    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void ciftKupYazdir(List<Integer> list){
        list.stream().filter(t->t%2==0).map(t->t*t*t).forEach(t-> System.out.print(t + " "));
    }

    //S8 : list in elemanlarin karelerini tekrarsiz yazdıralım
    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    public static void listElKareTekrarsiz(List<Integer> list){
        list.stream().map(t->t*t).distinct().forEach(t-> System.out.print(t + " "));
    }

    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyuge(List<Integer> list){
        list.stream().sorted().forEach(t-> System.out.print(t + " "));
    }

    //S10: listin elemanlarini buyukte kucuge siralayalim
    public static void buyuktenKucuge(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5kck(List<Integer> list){
        return list.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }

    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKare5kckdegil(List<Integer> list){
        return list.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }

    // S13 :list elemanlarini toplamini bulalim
    /*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

    public static void toplamiBul(List<Integer> sayi){
        int toplam = sayi.stream()
                .reduce(0, (a,b) -> a+b);
        System.out.println(toplam);
    }

    public static void toplamiBul2(List<Integer> sayi){
        System.out.println(sayi.stream()
                .reduce(0, Math::addExact));//veya Integer::sum
    }

    public static void toplamiBulPoz(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t -> t > 0)
                .reduce(0, Integer::sum));
    }
}
