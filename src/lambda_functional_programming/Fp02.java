package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {
    public static void main(String[] args) {
        /*
1)  t-> "Logic" , (t, u)-> "Logic"
    Bu yapıya "Lambda Expession"
2) Functional Programming kapsamında "Lambda Expession" kullanılabilir ama önerilmez.
   "Lambda Expession" yerine "Method Reference" tercih edilir.
3) "Method Reference" kullanımı "Class Name :: Method Name"

   Aynı zamanda kendi class'larınızı da kullanabilirsiniz.
   Örneğin bir Animal class'ınız var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
 */


        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        liste.add(3);
        System.out.println(liste);

      //  listElemanlariniYazdirFunctional(liste);

      //  ciftElemanlariYazdirFunctional(liste);
       // System.out.println();
        //tekElemanlarinKaresiniYazdirFunctional(liste);
        //System.out.println();
        //tekrarsizTekElemanlarinKupleriniYazdir(liste);
      //  tekrarsizCiftElemanlarinKareleriToplami(liste);
      // tekrarsizCiftElemanlarinKuplerininCarpimi(liste);
       getMaxEleman(liste);
        getMinEleman(liste);
        getTersSiraIleTekrarsizElemanlarinYarisi(liste);


    }
    /*1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran
        bir method oluşturun.(Functional ve method reference)
         */
    public static void listElemanlariniYazdirFunctional(List<Integer> list){
        System.out.println();
        list.stream().forEach(Utils::ayniSatirdBosluklaYazdir);
    }

   /* 2)Ardışık çift list elementlerini aynı satırda aralarında boşluk
   bırakarak yazdıran bir method oluşturun.(Functional)
    */

    public static void ciftElemanlariYazdirFunctional(List<Integer> list){
        System.out.println();
        list.stream().filter(Utils::ciftElemaniSec).forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk
    bırakarak yazdıran bir method oluşturun.(method reference)
     */
    public static void tekElemanlarinKaresiniYazdirFunctional(List<Integer> list){
        list.stream().filter(Utils::tekElemaniSec).map(Utils::karesiniAl).
                forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda
    aralarında boşluk bırakarak yazdıran bir method oluşturun.
     */
    public static void tekrarsizTekElemanlarinKupleriniYazdir(List<Integer> list){
        list.stream().distinct().filter(Utils::tekElemaniSec).
                map(Utils::kupAl).forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*/5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan
    bir method oluşturun.
     */
 /*   public static void tekrarsizCiftElemanlarinKareleriToplami(List<Integer> list){
        System.out.println();
       Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec)
               .map(Utils::karesiniAl).reduce(Utils::elemanlarinToplami).get();
        System.out.println(toplam);
    }

  */

    public static void tekrarsizCiftElemanlarinKareleriToplami(List<Integer> list){

        Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec)
                .map(Utils::karesiniAl).reduce(Math::addExact).get();
        System.out.println(toplam);

    }

    /*/6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

     */
   /* public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list){
        Integer carpim=list.stream().distinct().filter(Utils::ciftElemaniSec).
                map(Utils::kupAl).reduce(Utils::elemanlarinCarpimi).get();
        System.out.println(carpim);
    }

    */
    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list){

        Integer carpim=list.stream().distinct().filter(Utils::ciftElemaniSec)
                .map(Utils::kupAl).reduce(1,Math::multiplyExact);
        System.out.println(carpim);

    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void getMaxEleman(List<Integer> list){
    // Integer max=list.stream().distinct().sorted().reduce(Utils::elemanlariSirala).get();
   Integer max=   list.stream().distinct().reduce(Math::max).get();
        System.out.println(max);
    }
    /*
    /8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)
     */
    public static void getMinEleman(List<Integer> list){

        Integer min=   list.stream().distinct().reduce(Math::min).get();
        System.out.println(min);
    }


    /*
    9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
     */

    public static  void getYedidenBuyukCiftMin(List<Integer> list){
       Integer min= list.stream().distinct().filter(t-> t>7).filter(Utils::ciftElemaniSec).
                reduce(Math::min).get();
        System.out.println(min);
    }

    /*
    10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini
    (elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
     */
    public static void getTersSiraIleTekrarsizElemanlarinYarisi(List<Integer> list){
        List<Double> sonuc=  list.stream().distinct().filter(t->t>5).
                map(Utils::yarisiniAl).sorted(Comparator.reverseOrder()).collect(Collectors.toList());       ;
        System.out.println(sonuc);

        //collect(Collectors.toList()) ile yeni degerleri bir list icine aldik
    }


}
