import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class ContLei extends Cont implements GenerareIBAN, Tranzactie {

    @Override
    public String generareIBAN(String banca, String cnp) {  //?????????????????????????????????
        Random random=new Random();
        int numbRandom= random.nextInt();
        String stringRandom=String.valueOf(numbRandom);
        String ibanPersoanaNoua=null;
        String[] arrayIBAN=new String[5];
        arrayIBAN[0]="RO";
        arrayIBAN[1]="00";
        arrayIBAN[2]=banca;
        arrayIBAN[3]=stringRandom;
        arrayIBAN[4]=cnp;
        ibanPersoanaNoua=arrayIBAN.toString();
        return ibanPersoanaNoua;
    }
        public void contLei(Cont cont) {
            String numeDoc= cont.getNume()+" "+cont.getPrenume();
            File file = new File("D:\\Lucrari_JAVA\\Banca\\"+numeDoc+".txt");        if (file.exists()) {
                System.out.println("fisierul exista");
            }else {
                try (FileWriter fw = new FileWriter("D:\\Lucrari_JAVA\\Banca\\"+numeDoc+".txt", false);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    HashMap<String,String>datePersoana=new HashMap<>();
                    datePersoana.put("Nume: ",cont.getNume());
                    datePersoana.put("Prenume: ", cont.getPrenume());
                    datePersoana.put("Adresa: ", cont.getDomiciliu());
                    datePersoana.put("CNP: ", cont.getCnp());
                    datePersoana.put("Valuta:", "LEI");
                    datePersoana.put("IBAN: ", generareIBAN(cont.getBanca(), cont.getCnp()));
                    for(String str :datePersoana.keySet()) {
                        String str1=str+" "+datePersoana.get(str);
                        out.println(str1);
                    }
                }
                catch (IOException e) {
                }
            }
        }

    @Override
    public void tranzactiiEfectuate() {

    }
}