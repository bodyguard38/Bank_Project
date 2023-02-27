import java.util.Scanner;

public class Nieuw_KoffiezetApparaat {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        inlogMenu();

        String selVankoffie=selectieVanKoffie();
        System.out.println(selVankoffie+" wordt bereid.");
        Thread.sleep(2000);
        melkAdd();
        suikerAdd();
        String maatKiez = maatKiezen();
        decoratie();
        System.out.println(selVankoffie+" "+maatKiez+" wordt bereid.Eet smakelijk");
        decoratie();
    }

    private static String maatKiezen() throws InterruptedException {
        decoratie();
        System.out.println("Welke maat glas wil je?(klein,middle,groot)");
        decoratie();

        String maat = scanner.nextLine();

        switch (maat.toLowerCase()) {
            case "klein":
            case "middle":
            case "groot":
                System.out.println("Uw koffie "+maat+" wordt bereid.");
                Thread.sleep(2000);
                break;
            default:
                System.out.println("U hebt het verkeerde keuze gemaakt probeer het opnieuw");
        }
        return maat;
    }

    private static void suikerAdd() throws InterruptedException {
        decoratie();
        System.out.println("Wil je suiker toevoegen?(Antwoord met ja of nee)");
        decoratie();
        String  kiezenSuiker=scanner.nextLine();

        if (kiezenSuiker.equals("ja")){
            decoratie();
            System.out.println("Hoewel suikeer wil je toevoegen?");
            decoratie();

            int aantalSuiker=scanner.nextInt();
            scanner.nextLine();
            if(aantalSuiker>0){
                System.out.println(aantalSuiker+" suiker wordt toegevoegd");
                Thread.sleep(2000);
                return;
            }else{
                System.out.println("U hebt het verkeerde keuze gemaakt");
                Thread.sleep(2000);
                suikerAdd();
            }

        }else if (kiezenSuiker.equals("nee")){
            System.out.println("Geen suiker toegevoegd aan uw koffie.");
            Thread.sleep(2000);
        }else{
            System.out.println("U hebt het verkeerde keuze gemaakt");
            Thread.sleep(2000);
            suikerAdd();
        }


    }

    private static void melkAdd() throws InterruptedException {
        decoratie();
        System.out.println("Wil je melk toevoegen?(Antwoord met ja of nee)");
        decoratie();
        String sel=scanner.nextLine();
        if(sel.equals("ja")){
            System.out.println("melk toevoegen aan je koffie");
            Thread.sleep(2000);
        }else if(sel.equals("nee")){
            System.out.println("geen melk toegevoegd aan uw koffie");
        }else{
            System.out.println("U hebt een verkeerde keuze gemaakt");
            Thread.sleep(2000);
            melkAdd();
        }
    }

    private static String selectieVanKoffie() throws InterruptedException {


        while (true) {

            String selectie = scanner.nextLine();

            if(selectie.equalsIgnoreCase("turkse koffie")
                    ||(selectie.equalsIgnoreCase("filter koffie"))
                    ||(selectie.equalsIgnoreCase("espresso"))){

                return selectie;

            }else{
                System.out.println("U hebt de verkeerde keuze gemaakt.Atb probeer het opnieuw.");
                Thread.sleep(2000);
                inlogMenu();

            }
        }

    }

    private static void decoratie() {
        System.out.println("***************   ***   ***************");
    }

    private static void inlogMenu() {
        decoratie();
        System.out.println("Welke koffie wil je?");
        System.out.println("1. Turkse koffie");
        System.out.println("2. Filter koffie");
        System.out.println("3. Espresso");
        decoratie();

    }
}
