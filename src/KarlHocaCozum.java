import java.util.Scanner;

public class KarlHocaCozum {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Kahve secim asamasi

        // Kullaniciya hangi kahveyi istedigi sorulur ve kahve secenekleri yazdirilir.
        menuyuYazdir();
        // Kullaniciya hangi kahveyi sectigi sorulur ve alinan cevap bir degiskende tutulur.

        String kahveSecim = kahveSecimiYap();

        // Kullanicinin sectigi kahveye gore konsola bilgilendirme mesaji yazdirilir.

        System.out.println(kahveSecim + " hazirlaniyor");


        // Sut ekleme asamasi

        // Kullaniciya sut isteyip istemedigi sorulur ve cevap bir String degiskende saklanir.
        sutEkle();
        // Kullanici evet yaniti verdiyse 'Sut ekleniyor' yazdirilir, Hayir cevabi verdiyse 'sut eklenmiyor' yazdirilir

        // Seker ekleme asamasi

        // Kullaniciya seker isteyip istemedigi sorulur ve yanit evet ise kac seker istedigi sorularak konsola
        // '{sekerSayisi} seker ekleniyor'
        sekerEkle();
        // Kullanici seker istemiyorsa seker eklenmiyor mesaji yazdirilir

        // Boy secim asamasi

        // Kullaniciya secilebilecek boy bilgileri yazdirilir ve kullanicidan secim yapmasi beklenir
        String boySecim = boySecimiYap();
        // Secim buyuk boy ise Kahveniz buyuk boy hazirlaniyor

        // Secim orta boy ise Kahveniz orta boy hazirlaniyor

        // Secim kucuk boy ise Kahveniz kucuk boy hazirlaniyor

        // Sonuc asamasi
        System.out.println(kahveSecim + " " + boySecim + " olarak hazirlandi. Afiyet olsun! Yeniden bekleriz...");
        //Kullaniciya istedigi kahve ve boy bilgileri yazdirilir.






    }

    private static String boySecimiYap() {
        System.out.println("***************************************************\n\nHangi boyutta olsun? (Büyük boy - orta boy - küçük boy olarak giriniz.)\n\n***************************************************");
        String boySecim = sc.nextLine();

        switch (boySecim.toLowerCase()){
            case "buyuk boy":
            case "orta boy":
            case "kucuk boy":
                System.out.println("Kahveniz " + boySecim + " hazirlaniyor");
                break;

            default:
                System.out.println("Yanlis giris yaptiniz lutfen dogru boy giriniz...");
                boySecimiYap();
                break;
        }
        return boySecim;
    }

    private static void sekerEkle() {
        System.out.println("***************************************************\n\nSeker eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız):\n\n***************************************************");

        String sekerSecim = sc.nextLine();

        if (sekerSecim.equalsIgnoreCase("evet")) {
            System.out.println("***************************************************\n\nKac seker eklememizi istersiniz?\n\n***************************************************");
            int sekerSayisi = sc.nextInt();
            sc.nextLine(); // Onemli dummy

            if(sekerSayisi>0){
                System.out.println(sekerSayisi + " seker ekleniyor.");
            }else {
                System.out.println("Yanlis girdi yaptiniz Lutfen dogru girdi yapiniz");
                sekerEkle();
            }

        } else if (sekerSecim.equalsIgnoreCase("hayir")) {
            System.out.println("\nSeker eklenmiyor");
        } else {
            System.out.println("Yanlis giris yaptiniz. Lutfen Evet veya Hayir yaziniz...");
            sekerEkle();
        }

    }

    private static void sutEkle() {

        System.out.println("***************************************************\n\nSüt eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız):\n\n***************************************************");
        String sutSecim = sc.nextLine();

        if (sutSecim.equalsIgnoreCase("evet")) {
            System.out.println("\nSut ekleniyor.");
        } else if (sutSecim.equalsIgnoreCase("hayir")) {
            System.out.println("\nSut eklenmiyor");
        } else {
            System.out.println("Yanlis giris yaptiniz. Lutfen Evet veya Hayir yaziniz...");
            sutEkle();
        }
    }

    private static String kahveSecimiYap() {

        // Oyle bir method gelistir ki kullanici dogru secim yapana kadar methoddan cikamasin

        while(true){
            // kullanicidan bir girdi talep edilir  ve alinan girdi bir degiskende saklanir
            String secim = sc.nextLine();

            // Bu degiskenim eger kabul edilebilir bir girdi ise methoddan cikilir, degil ise menu tekrardan yazdirilarak dongunun basina donulur.
            if((secim.equalsIgnoreCase("turk kahvesi")) ||
                    (secim.equalsIgnoreCase("filtre kahve")) ||
                    (secim.equalsIgnoreCase("espresso"))){

                return secim;
            }else{
                System.out.println("Yanlis secim yaptiniz. Lutfen dogru bir giris yapiniz...");
                menuyuYazdir();
            }

        }


    }

    private static void menuyuYazdir() {
        System.out.println("*******************************************\n");
        System.out.println("Hangi kahveyi istersiniz?");
        System.out.println("1. Turk Kahvesi");
        System.out.println("2. Filtre Kahve");
        System.out.println("3. Espresso");
        System.out.println("\n*******************************************\n\n");
    }
}
