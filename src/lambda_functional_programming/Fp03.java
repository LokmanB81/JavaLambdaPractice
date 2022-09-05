package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Fp03 {
    public static final String ANSI_MAVI = "\u001B[34m";
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

       // tumElemanlariBuyukHarfleYazadırma(liste);
        System.out.println();
      //  tumElemanlariBuyukHarfleYazadırma2(liste);
      //  uzunlugaGoreYazdir(liste);
        //System.out.println(ANSI_MAVI + "Bakın bu yazı mavi olarak çıkacaktır ");
       // uzunlugaGoreTersSiraIleYazdir(liste);
       // sonKaraktereGoreTekrarsizYazdirma(liste);
      //  uzunlukVeIlkKaraktereGoreSiralama(liste);
       // elemanlariSil(liste);
        //elemanlariSil2(liste);
        System.out.println(liste);
        baslangiciAYadaSonuNOlaniSil(liste);
        //baslangiciAYadaSonuNOlaniSil2(liste);

       // uzunlugu8Ile10ArasiVeOIleBiteniSil(liste);



    }
/*
1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.
 */
    /*
    1. yol
     */
    public static void tumElemanlariBuyukHarfleYazadırma(List<String> list){
        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*
   2. yol
    */
 /*   public static void tumElemanlariBuyukHarfleYazadırma2(List<String> list){
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }*/

    /*2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.
*/
    public static  void uzunlugaGoreYazdir(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).
                forEach(Utils::ayniSatirdBosluklaYazdir);
        //Comparator.comparing(String::length) sıralama kosutunu belirlemek icin kullanilir.
    }

    /*
    3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.
     */
    public static  void uzunlugaGoreTersSiraIleYazdir(List<String> list) {
        System.out.println();
        list.stream().sorted(Comparator.comparing(String::length).
                reversed()).forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*
     Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.
     */
    public static void sonKaraktereGoreTekrarsizYazdirma(List<String > list){
        System.out.println();
        list.stream().distinct().sorted(Comparator.comparing(Utils::sonKarakterial)).
        forEach(Utils::ayniSatirdBosluklaYazdir);
    }

    /*
   5 ) Elemanları önce uzunluklarına göre ve sonra ilk karakterine
    göre sıralayıp yazdıran bir method oluşturun.
     */

    public static void uzunlukVeIlkKaraktereGoreSiralama(List<String > list){
        System.out.println();
        list.stream().sorted(Comparator.comparing(String::length).
                thenComparing(Utils::ilkKarakterial)).forEach(Utils::ayniSatirdBosluklaYazdir);
    }
    /*
    6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.
     */

    public static void elemanlariSil(List<String> list){
        System.out.println();
        list.removeIf(t->t.length()>5);
        System.out.println(list);   // orjinal liste : [Ali, Ali, Mark]
    }

  /*  public static void elemanlariSil2(List<String> list){
        System.out.println();
        list.stream().filter(t->t.length()<5).collect(Collectors.toList()).
                forEach(Utils::ayniSatirdBosluklaYazdir);
        System.out.println(list);   // orjinal liste : [Ali, Ali, Mark]
    }*/
    /*


   7 ) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
     */

    public static  void baslangiciAYadaSonuNOlaniSil(List<String > list){
        list.removeIf(t->(t.charAt(0)=='A' || t.charAt(0)=='a' || t.charAt(t.length()-1)=='N') || t.charAt(t.length()-1)=='n');
        System.out.println(list);
    }
    /*
    2. yol
     */
    public static  void baslangiciAYadaSonuNOlaniSil2(List<String > list){
        System.out.println();
       list.removeIf(t->t.startsWith("A") || t.endsWith("a") || t.startsWith("N") || t.endsWith("n"));
        System.out.println(list);
    }

    /*
    8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları silen bir method oluşturun.
     */

    public  static  void uzunlugu8Ile10ArasiVeOIleBiteniSil(List<String> list){
        list.removeIf(t->  (t.length()>7 && t.length()<11) || t.endsWith("o")  );
        System.out.println(list);
    }


}
