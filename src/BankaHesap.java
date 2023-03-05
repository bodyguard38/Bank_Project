import java.util.Scanner;

public class BankaHesap {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Customer customer1=new Customer("Ahmet Aktas","123456789","ahmet123",1000);

        //Kullaniciya hesap numarasi ve sifresi sorularak kontrol saglanir. Dogruysa sisteme giris yapilir.
        //Yanlissa sisteme dogru bilgi girilene kadar soru tekrarlanir.
        while(true){
            yildizlarlaYazdir("BANKA UYGULAMAMIZA HOSGELDINIZ");
            System.out.println("Lutfen hesap numaranizi giriniz: ");
            String hesapInput = scanner.nextLine();

            if(hesapInput.equals(customer1.accountNo)){
                System.out.println("Sifrenizi giriniz: ");
                String sifreInput = scanner.nextLine();
                if(sifreInput.equals(customer1.password)){
                    System.out.println("SAYIN "+ customer1.name.toUpperCase() + " HOSGELDINIZ....");
                    break;
                }else {
                    System.out.println("SIFRENIZ YANLISTIR. LUTFEN TEKRAR DENEYINIZ...");
                }
            }else {
                System.out.println("HESAP NUMARANIZ YANLISTIR. LUTFEN DOGRU BILGILERLE TEKRAR DENEYINIZ...");
            }
        }
        int devam =1;
        //kullanici giris yaptiktan sonra ana menude birtakim seceneklerle karsilasir.
        while(devam==1){
            //ana menuyu yazdir
            anaMenu();
            //kullanicidan islem girdisi al
            int islem = scanner.nextInt();
            //kullanici girdisine gore cagirilmasi gereken metodlari cagir

            switch (islem){
                case 1:
                    bakiyeYazdir(customer1);
                    devam = devamMi();
                    break;
                case 2:
                    paraYatir(customer1);
                    devam = devamMi();
                    break;
                case 3:
                    paraCek(customer1);
                    devam = devamMi();
                    break;
                    case 4:
                        devam = 0;
                        break;
                default:
                    System.out.println("Lutfen dogru bir islem seciniz.");
                    break;
            }

        }
        yildizlarlaYazdir("Bankamizi tercih ettiginiz icin tesekkur eder iyi gunler dileriz");
    }

    private static void paraCek(Customer customer1) {
        System.out.println("Ne kadar cekmek istiyorsunuz?");
        double miktarInput = scanner.nextDouble();
        if (sayiPozitifMi(miktarInput)){
            customer1.withdrawMoney(miktarInput);
        }else {
            System.out.println("Lutfen pozitif bir sayi giriniz.");
            paraCek(customer1);
        }
    }

    private static void paraYatir(Customer customer1) {
        System.out.println("Ne kadar para yatirmak istiyorsunuz?");
        double miktarInput = scanner.nextDouble();
        if(sayiPozitifMi(miktarInput)){
            customer1.addBalance(miktarInput);
        }else {
            System.out.println("Lutfen pozitif bir sayi giriniz.");
            paraYatir(customer1);
        }
    }

    private static boolean sayiPozitifMi(double i) {
        if(i>0) {
            return true;
        }
        return false;
    }

    public static void bakiyeYazdir(Customer customer){
        customer.printBalance();
    }
    public static int devamMi(){
        System.out.println("Islem yapmaya devam etmek istiyor musunuz?" +
                "1. Evet " +
                "2. hayir  " +
                "tuslayiniz ");

        int devamInput=scanner.nextInt();
        return devamInput;
    }
    public static void yildizlarlaYazdir(String text){
        System.out.println("*****************************************************" +
                "**********************************\n\n");
        System.out.println(text);
        System.out.println("*****************************************************" +
                "**********************************\n\n");
    }
    public static void anaMenu(){
        yildizlarlaYazdir("Lutfen yapacaginiz islemi seciniz\n\n--------------------------------------" +
                "----------\n"+
                "1 - Bakiye yazdir\n"+
                "2 - Para yatir\n"+
                "3 - Para cek\n"+
                "4 - Cikis yap"+
                "\n------------------------------------------------");
    }
}
