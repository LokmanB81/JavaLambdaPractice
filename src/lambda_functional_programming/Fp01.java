package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    /*
  1) Lambda (Functional Programming) Java 8 ile kullanılmaya başlanmıştır.
  2) Functional Programming'de "Ne yapılacak" (What to do) üzerine yoğunlaşılır.
     Structured Programming "Nasıl yapılacak" (How to do) üzerine yoğunlaşılır.
  3) Functional Programming, Arrays ve Collections ile kullanılır.
  4) "entrySet() methodu ile Map, Set'e dönüştürülerek Functional Programming'de kullanılabilir.

   */
    public static void main(String[] args) {

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

      /*  /1) Ardışık list elementlerini aynı satırda
      aralarında boşluk bırakarak yazdıran bir method oluşturun.
      (Structured)
       */
      //  listElemanlariniYazdirStructered(liste);
      //  System.out.println();
      //  listElemanlariniYazdirFunctional(liste);
       // System.out.println();
      //  ciftElemanlariYazdirStructured(liste);
       // System.out.println();
     // ciftElemanlariYazdirFunctional(liste);
       // System.out.println();
      // tekElemanlariYazdirFunctional(liste);
       // System.out.println();
        //tekElemanlarinKaresiniYazdirFunctional(liste);
      //  System.out.println();
        //tekrarsizTekElemanlarinKupleriniYazdirFunctional(liste);
       // System.out.println();
       // tekrarsizCiftElemanlarinKareleriToplamiYazdirFunctional(liste);

      //  tekrarsizCiftElemanlarinKareleriCarpimiYazdirFunctional(liste);

        tekrarsizCiftElemanlarinKuplerininCarpimi(liste);
        getMaxEleman(liste);
        getMaxEleman02(liste);
        getMinEleman(liste);
        getYedidenBuyukCiftMin(liste);
        getYedidenBuyukCiftMin2(liste);
        getYedidenBuyukCiftMin3(liste);
        getTersSiraIleTekrarsizElemanlarinYarisi(liste);

    }

    public static void listElemanlariniYazdirStructered(List<Integer> list){

        for (Integer each:list
             ) {
            System.out.print(each+" ");
        }

    }

    /*/1)Ardışık list elementlerini aynı satırda aralarında boşluk
    bırakarak yazdıran bir method oluşturun.(Functional)
     */
    public static void listElemanlariniYazdirFunctional (List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+"   "));
    }


    /*/2)Ardışık çift list elemanlarini aynı satırda aralarında boşluk
    bırakarak yazdıran bir method oluşturun.(Structured)
     */
    public static void ciftElemanlariYazdirStructured(List<Integer> list){
        for (Integer each:list
             ) {
            if(each%2==0){
                System.out.print(each+" ");
            }
        }
    }


    /*/2)Ardışık çift list elementlerini aynı satırda aralarında boşluk
    bırakarak yazdıran bir method oluşturun.(Functional)
     */
    public static void ciftElemanlariYazdirFunctional(List<Integer> list){
        list.stream().filter(t->t%2==0 ).forEach(t-> System.out.print(t+"   "));
    }

    /*tek sayi olup 5 ten buyuk olanlari functional yazdiralim
 */
    public static void tekElemanlariYazdirFunctional(List<Integer> list){
        list.stream().filter(t->t%2!=0 & t>5).forEach(t-> System.out.print(t+"   "));
    }

   /* /3) Ardışık tek list elementlerinin karelerini aynı satırda
   aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
   elemanların değerleri değişecekse map() methodu kullanılır.
    */
   public static void tekElemanlarinKaresiniYazdirFunctional(List<Integer> list) {
       list.stream().filter(t -> t%2!= 0).map(t->t*t).forEach(t -> System.out.print(t  + "   "));
   }
/*/4) Ardışık tekrarsız tek list elementlerinin küplerini aynı satırda
aralarında boşluk bırakarak yazdıran bir method oluşturun.
 */
    public static void tekrarsizTekElemanlarinKupleriniYazdirFunctional(List<Integer> list){
        list.stream().distinct().filter(t-> t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }

    /*/5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan
    bir method oluşturun.
     */
    public static void tekrarsizCiftElemanlarinKareleriToplamiYazdirFunctional(List<Integer> list){
        Integer toplam=list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);

        System.out.println(toplam);
    }
    /*/5.1) Tekrarsız çift elementlerin karelerinin carpimi hesaplayan,
        bir method oluşturun.
         */
    public static void tekrarsizCiftElemanlarinKareleriCarpimiYazdirFunctional(List<Integer> list){
        Integer carpim=list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(1, (t, u) -> t * u);
        System.out.println(carpim);                         // reduce icerisinde t'ye baslangic degeri atatdik 1 olarak
    }

    /*/6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

     */
    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list){
        Integer carpim=list.stream().distinct().filter(t-> t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(carpim);
    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void getMaxEleman(List<Integer> list){
        Integer max=list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)-> t>u ? t:u);
        //Integer max=list.stream().distinct().reduce(list.get(0),(t,u)-> t>u ? t:u); 'da olabilir..
        System.out.println(max);
    }

    // 7. task ikinci yontem
    public static void getMaxEleman02(List<Integer> list){
        list.stream().distinct().sorted().forEach(t-> System.out.print(t+" "));
        System.out.println();
        Integer max=list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)-> u);
        //Integer max=list.stream().distinct().reduce(list.get(0),(t,u)-> t>u ? t:u);
        System.out.println("2. yomtem : "+max);
    }

    // 8) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void getMinEleman(List<Integer> list) {
        Integer min = list.stream().distinct().reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        //Integer max=list.stream().distinct().reduce(list.get(0),(t,u)-> t>u ? t:u);
        System.out.println(min);
    }

    /* /9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
        1. yöntem
     */
    public static void getYedidenBuyukCiftMin(List<Integer> list){
        Integer min=list.stream().distinct().filter(t-> t%2==0).filter(t-> t>7).
                reduce(Integer.MAX_VALUE,(t,u)-> t<u ? t : u);
        System.out.println("1. yol : "+min);
    }
// 2. yontem
    public static void getYedidenBuyukCiftMin2(List<Integer> list){

        list.stream().distinct().filter(t-> t%2==0).filter(t-> t>7).
                sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
        System.out.println();
        Integer min=list.stream().distinct().filter(t-> t%2==0).filter(t-> t>7).
                sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t, u)-> u);
        System.out.println("2. yol : "+min);
    }

    // 3. yol
    public static void getYedidenBuyukCiftMin3(List<Integer> list){

        list.stream().distinct().filter(t-> t%2==0).filter(t-> t>7).
                sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
        System.out.println();
        Integer min=list.stream().distinct().filter(t-> t%2==0).filter(t-> t>7).
                sorted().findFirst().get();
        System.out.println("3. yol : "+min);
    }
    /*/10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların
    yarı değerlerini(elamanın ikiye bölüm sonucunu)  bulan bir method oluşturun.
     */
    public static void getTersSiraIleTekrarsizElemanlarinYarisi(List<Integer> list){
      List<Double> sonuc=  list.stream().distinct().filter(t-> t>5).map(t-> t/2.0).
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonuc);

        // 2.0 a bolerek sonucu double olarak olusturduk
        //collect(Collectors.toList()) ile yeni degerleri bir list icine aldik
    }



}
