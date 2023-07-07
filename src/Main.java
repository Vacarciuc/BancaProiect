import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        Banci banci=new Banci();
        ValidarePersoanaExistente validarePersoanaExistente=new ValidarePersoanaExistente();
        System.out.println("Va rugam selectati banca!");
        System.out.println("1. Banca ING" +"\n"+
                "2.Banca BCR" +"\n"+
                "3.Banca BRD" +"\n"+
                "4.Banca BT");
        System.out.print("alegeti o banca:");  int selBank=scanner.nextInt();
            banci.selectBank(selBank);
        System.out.println("Va rugam sa introduceti CNP pentru validare:");
        System.out.print("Introduceti CNP: ");    String getCNPVerificare = scanner1.nextLine();
            validarePersoanaExistente.validarePersoana(getCNPVerificare);
    }
}