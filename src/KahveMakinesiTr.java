import java.util.Scanner;

public class KahveMakinesiTr {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {




        menuyuYazdir();

        String kahveSecim = kahveSecimiYap();

        System.out.println(kahveSecim + " hazirlaniyor.");
        Thread.sleep(2000);

        sutEkle();

        sekerEkle();

        String boySecim=boySecimi();

        dekoratifSus();
        System.out.println(kahveSecim+" "+boySecim+" olarak hazirlandi.Afiyet olsun.");
        dekoratifSus();
    }

    private static void dekoratifSus() {
        System.out.println("************************************************");
    }

    private static String boySecimi() throws InterruptedException {
        dekoratifSus();
        System.out.println("Hangi boyut olsun?  (buyuk boy-orta boy-kucuk boy)");
        dekoratifSus();
        String boySecim = scanner.nextLine();

        switch (boySecim.toLowerCase()) {
            case "buyuk boy":
            case "orta boy":
            case "kucuk boy":
                System.out.println("Kahveniz "+boySecim+" hazirlaniyor");
                Thread.sleep(2000);
               break;
            default:
                System.out.println("Yanlis giris yaptiniz tekrar deneyiniz");
                Thread.sleep(2000);
                boySecimi();
        }
        return boySecim;
    }

    private static void sekerEkle() throws InterruptedException {
        dekoratifSus();
        System.out.println("Seker eklemek ister misiniz?  (evet/hayir)");
        dekoratifSus();
        String sekerSecim = scanner.nextLine();

        if(sekerSecim.equalsIgnoreCase("evet")) {
            dekoratifSus();
            Thread.sleep(2000);
            System.out.println("Kac seker eklememizi istiyorsunuz?");
            dekoratifSus();
            int sekerSayisi = scanner.nextInt();
            scanner.nextLine();
            if(sekerSayisi >0){
                System.out.println(sekerSayisi + " seker kahvenize eklendi");
                Thread.sleep(2000);
            }else{
                System.out.println("Yanlis giris yaptiniz lutfen dogru bisey girinizz!!");
                sekerEkle();
            }

        } else if (sekerSecim.equalsIgnoreCase("hayir")) {
            System.out.println("Kahvenize seker eklenmyor.");
            Thread.sleep(2000);
        }else{
            System.out.println("Yanlis bir giris yaptiniz lutfen belirtilen bir deger giriniz !!");
            sekerEkle();
        }
    }

    private static void sutEkle() throws InterruptedException {
        dekoratifSus();
        System.out.println("Sut eklemek ister misiniz?(evet veya  hayir olarak cevaplayiniz): ");
        dekoratifSus();
        String sutSecim = scanner.nextLine();

        if(sutSecim.equalsIgnoreCase("evet")) {
            System.out.println("Kahvenize sut ekleniyor");
            Thread.sleep(2000);
        } else if (sutSecim.equalsIgnoreCase("hayir")) {
            System.out.println("Kahvenize sut eklenmyor");
            Thread.sleep(2000);
        }else{
            System.out.println("Yanlis bir giris yaptiniz lutfen belirtilen bir deger giriniz !!");
            sutEkle();
        }
    }

    private static String kahveSecimiYap() throws InterruptedException {
        //oyle bir method gelistir ki kullanici dogru secim yapana kadar methoddan cikmasin

        while (true){
            //kullanicidan bir girdi alinir ve alinan bilgi bir degiskende saklanir
            String secim = scanner.nextLine();

            //bu degisken kabul edilebilir bir dongu ise bir degiskende saklanir degil ise menu menu tekrardan yazdirilarak dongunun basina donulur

            if(secim.equalsIgnoreCase("turk kahvesi")
                    ||secim.equalsIgnoreCase("filtre kahvesi")
                    ||secim.equalsIgnoreCase("expresso")){

                return secim;
            }else{
                System.out.println("Yanlis secim yaptiniz lutfen dogru bir giris yapiniz !");
               Thread.sleep(2000);
                menuyuYazdir();
            }

        }

    }

    private static void menuyuYazdir() {
        dekoratifSus();
        System.out.println("Hangi kahveyi istersiniz?");
        System.out.println("1. Turk kahvesi");
        System.out.println("2. Filtre kahvesi");
        System.out.println("3. Expresso");
        dekoratifSus();

    }
}