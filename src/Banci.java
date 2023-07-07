public class Banci {
    String bankING="ING";
    String bancBCR="BCR";
    String bankBRD="BRD";
    String bankBT="BT";


Cont cont=new Cont() {};
    public void selectBank(int bankNumb){
        switch (bankNumb){
            case 1:
               // System.out.println(bankING);
                cont.setBanca("ING");
                break;
            case 2:
               // System.out.println(bancBCR);
                cont.setBanca("BCR");
                break;
            case 3:
               // System.out.println(bankBRD);
                cont.setBanca("BRD");
                break;
            case 4:
               // System.out.println(bankBT);
                System.out.println("BT");
                break;
            default:
                System.out.println("Banca "+ bankNumb +" nu exista");
        }
    }
}
