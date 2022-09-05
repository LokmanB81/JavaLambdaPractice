package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp05 {
    public static void main(String[] args) {
        Courses courseTurkishDay = new Courses("Summer", "Turkish Day", 97, 128);
        Courses courseTurkishNight = new Courses("Winter", "Turkish Night", 98, 154);
        Courses courseEnglishDay = new Courses("Spring", "English Day", 95, 132);
        Courses courseEnglishNight = new Courses("Winter", "English Night", 93, 144);
        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);
        System.out.println(coursesList);

        System.out.println("OrtPuanlarverilenSayidanBuyukMu : "+ortalamaPuanlarverilenSayidanBuyukMu(coursesList,99));
        System.out.println("Kelime var mi : "+ kursadiVerilenKelimeyiiICeriyorMu(coursesList,"Turkish"));
        System.out.println(ortalamasiEnYksekKursAdiYazdir(coursesList));

        System.out.println(ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(coursesList,1));


    }
    /*
        1)Tüm ortalama puanların verilen sayıdan büyük olup olmadığını
        kontrol etmek için bir method oluşturun.
         */
    public static boolean ortalamaPuanlarverilenSayidanBuyukMu(List<Courses> list,double x){
        return list.stream().allMatch(t->t.getAverageScore()>x);
    }

    /*
    2)Kurs adlarından en az birinin verilen kelimeyi içerip içermediğini kontrol
    etmek için bir method oluşturun
       */
    public static boolean kursadiVerilenKelimeyiiICeriyorMu(List<Courses> list, String kelime){
        return list.stream().anyMatch(t->t.getCourseName().contains(kelime));
    }

    /*
    3) Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun
     */

    public static String ortalamasiEnYksekKursAdiYazdir(List<Courses> list){
       Object obj= list.stream().sorted(Comparator.comparing(Courses::getAverageScore).
                reversed()).findFirst().get().getCourseName();
        return (String) obj;

    }

    /*
    3) Ortalama puanı en az olan kursu yazdırmak için bir yöntem oluşturun
     */

  /*  public static String ortalamasiEnAzKursAdiYazdir(List<Courses> list){
        Object obj= list.stream().sorted(Comparator.comparing(Courses::getAverageScore).
                get().getCourseName();
        return (String) obj;

    }*/
    /*
    4) Liste öğelerini artan düzende ortalama puana göre sıralayın ve
    ilk verilenleri atlayın
    */

    public static List<Courses> ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(List<Courses> list,int x){
     return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).
     skip(x).collect(Collectors.toList());
    }
}
