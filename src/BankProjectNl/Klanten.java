package BankProjectNl;

public class Klanten {
    public String naam;
    public String rekeningNummer;
    public String telephoonNummer;
    public String email;
    public double rekeningSaldo;
    public String wachtwoord;

    public Klanten(String naam, String rekeningNummer, double rekeningSaldo, String wachtwoord) {
        this.naam = naam;
        this.rekeningNummer = rekeningNummer;
        this.rekeningSaldo = rekeningSaldo;
        this.wachtwoord = wachtwoord;
        afdrukInformatie();
    }

    public void afdrukInformatie() {
            System.out.println(
                        "Naam= " + naam +
                        "\nRekeningNummer=" + rekeningNummer +
                        "\nTelephoonNummer=" + telephoonNummer +
                        "\nEmail=" + email );
    }

    public void geldStorten(double storten) {
        this.rekeningSaldo = storten;
        System.out.println("Beste" +naam+ "Er is "+storten+" Euro op uw rekening gestord");
    }
    public void geldOpnemen(double opnemen) {
        if(opnemen<=this.rekeningSaldo) {
            this.rekeningSaldo -= opnemen;
            System.out.println("Beste" +naam+ "Er is "+opnemen+" Euro op uw rekening afgeschreven");
        }else {
            System.out.println("Intrekking mislukt. onvoldoende saldo");
        }
    }
    public void saldoAfdrukke() {
        System.out.println("uw saldo: "+rekeningSaldo);
    }

    public void resetWachtwoord(){}
}
