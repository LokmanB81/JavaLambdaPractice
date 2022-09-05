package lambda_functional_programming;

import java.util.stream.IntStream;

public class Fp04 {
    public static void main(String[] args) {

        System.out.println(faktoriyelHesapla(5));
        System.out.println(araliktakiCiftSayilarinToplami(7,2));
        System.out.println(aralitakiSayilarinRakamlarToplami(23,32));

    }



    public static int faktoriyelHesapla(int x) {

        if (x >= 0) {
            return IntStream.rangeClosed(1,x).reduce(Math::multiplyExact).getAsInt();
        }
        System.out.println("0'dan buyuk bir deger giriniz");
        return 0;
    }

    /*
    4) Verilen iki sayı arasındaki çift sayıların toplamını bulan bir method oluşturun.
     */
    public static int araliktakiCiftSayilarinToplami(int x, int y){
int z=0;
        if(x>y){
            z=x;
            x=y;  // eger x y'den buyuk ise x ve y yer degistirdi..
            y=z;
        }
        return IntStream.rangeClosed(x,y).filter(Utils::ciftElemaniSec).sum();
    }

    /*
    Verilen iki sayı arasındaki tüm sayıların rakamlarının toplamını hesaplayan bir method oluşturun.
    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +  2+7  +   2+8  +   2+9  +
    3+0  +   3+1  +   3+2 ==> 68

     */
    public static int aralitakiSayilarinRakamlarToplami(int x,int y){
        int z=0;
        if(x>y){
            z=x;
            x=y;  // eger x y'den buyuk ise x ve y yer degistirdi..
            y=z;
        }
        return IntStream.rangeClosed(x,y).map(Utils::rakamlarToplamiHesapla).sum();
    }
}
