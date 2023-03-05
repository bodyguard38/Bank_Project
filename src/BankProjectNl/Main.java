package BankProjectNl;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Klanten klanten1 = new Klanten("Ahmet Aktas","123456789",1000,"Ahmet123");

        while (true) {
            decoratie("Welkom bij onze bank");
            System.out.print("Vul in rekening nummer :");
            String rekeningInput = scanner.nextLine();
            System.out.print("Vul in uw wachtwoord :");
            String wachtwoordInput = scanner.nextLine();
            if(rekeningInput.equals(klanten1.rekeningNummer)) {
                if(wachtwoordInput.equals(klanten1.wachtwoord)){
                    System.out.println("Beste "+klanten1.naam.toUpperCase()+" HARTELIJKE WELKOM");
                    break;
                }else {
                    System.out.println("Je wachtwoord is verkeerd.Nog een keer proberen");
                }

            }else {
                System.out.println("Je rekeningnummer is verkeerd.Nog een keer proberen");
            }
        }
        hoofdMenu();
        int doorGaan = 1;

        while (doorGaan == 1) {

            int proces = scanner.nextInt();
            switch (proces) {
                case 1:
                    saldoAfdrukken(klanten1);
                    doorGaan = doorGaanOfNiet();
                    break;
                case 2:
                    geldStorten(klanten1);
                    doorGaan = doorGaanOfNiet();
                    break;
                case 3:
                    geldOpnemen(klanten1);
                    doorGaan = doorGaanOfNiet();
                    break;
                case 4:
                    decoratie("Bedankt dat je voor onze bank hebt gekozen. We kijken ernaar uit je weer te zien");
                    doorGaan = 0;
                    break;

                default:
                    System.out.println("Vul a.u.b. een juiste waarde in..");
                    break;
            }
        }



}

    private static void geldOpnemen(Klanten klanten1) {
        System.out.println("Hoewel geld opnemen?");
        double geldInput = scanner.nextDouble();

        if(isHetPositie(geldInput)){
            klanten1.geldOpnemen(geldInput);
        }else {
            System.out.println("Vul in het positie alt!!!");
            geldOpnemen(klanten1);
        }
    }

    public static void geldStorten(Klanten klanten1) {
        System.out.println("Hoewel geld storten?");
        double geldInput = scanner.nextDouble();

        if(isHetPositie(geldInput)){
            klanten1.geldStorten(geldInput);
        }else {
            System.out.println("Vul in het positie alt!!!");
            geldStorten(klanten1);
        }
    }

    public static boolean isHetPositie(double i) {
        if (i > 0) {
            return true;

        }return false;
    }

    public static void saldoAfdrukken(Klanten klanten) {

    }

    public static int doorGaanOfNiet() {
        System.out.println(" Wilt u doorgaan met verwerken? \n"+
                "1. Ja\n"+
                "2. Nee\n");
        int doorGaanInput = scanner.nextInt();

        return doorGaanInput;

    }
    public static void decoratie(String text) {
        System.out.println("**********************************************************************************\n\n");
        System.out.println(text);
        System.out.println("\n\n**********************************************************************************\n\n");

    }
    public static void hoofdMenu() {
        decoratie("Wat wil je doen?"+"----------------------------\n"+
                "1-Saldo Afdrukken\n"+
                "2-Geld storten\n"+
                "3-Geld opnemen\n"+
                "4-Uitgaan\n"+
                "-----------------------------------");

    }
}
