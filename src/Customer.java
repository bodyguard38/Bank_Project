public class Customer {
    public String name;
    public String accountNo;
    public String password;
    public String phone;
    public String email;
    public double balance;

    public Customer(String name, String accountNo, String password, double balance){
        this.name = name;
        this.accountNo = accountNo;
        this.password = password;
        this.balance=balance;

        printInformation();
    }

    private void printInformation() {
        System.out.println(
                "Name: " + name +
                        "\nAccount Number: " + accountNo +
                        "\nPhone: " + phone +
                        "\nE-mail: " + email);
    }

    public void addBalance(double amount){
        this.balance+=amount;
        System.out.println("Sayin "+ name + " hesabiniza " +amount+" TL yatirilmistir.");
    }
    public void withdrawMoney(double amount){
        if (amount <=this.balance){
            this.balance-=amount;
            System.out.println("Sayin "+ name + " hesabiniza " +amount+" TL cekilmistir.");

        }else{
            System.out.println("Pra cekme islemi basarisiz.Yetersiz bakiye.");
        }
    }
    public void printBalance(){
        System.out.println("Bakiyeniz: " + balance);
    }
    public void changePassword(){
        //Sifre degistirme islemleri
    }
}
