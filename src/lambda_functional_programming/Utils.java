package lambda_functional_programming;

public class Utils {

    public static void ayniSatirdBosluklaYazdir(Object obj){
        System.out.print(obj+" ");
    }

    public static boolean ciftElemaniSec(Integer x){
        return x%2==0;
    }

    public static boolean tekElemaniSec(Integer x){
        return x%2!=0;
    }

    public static Integer karesiniAl(Integer x){
        return x*x;
    }

    public static Integer kupAl(Integer x){
        return x*x*x;
    }

    public static Integer elemanlarinToplami(Integer x,Integer y){

        return x+y;
    }

    public static Integer elemanlarinCarpimi(Integer x,Integer y){

        return x*y;
    }

    public static Integer elemanlariSirala(Integer x,Integer y){

        return y;
    }

    public static Double yarisiniAl(int x){

        return x/2.0;// 2.0 a bolerek sonucu double olarak olusturduk
    }

    public static char sonKarakterial(String x){
        return x.charAt(x.length()-1);
    }
    public static char ilkKarakterial(String x){
        return x.charAt(0);
    }

    public static int rakamlarToplamiHesapla(int x){
        int toplam=0;
        while (x>0){
           toplam += x%10;
           x/=10;
        }
        return toplam;
    }



}
