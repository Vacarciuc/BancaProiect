import java.io.*;
import java.util.*;

public class ValidarePersoanaExistente implements  VerificareExistentaCont{
    boolean validare=false;
    boolean contInexistent=false;
    String validKey=null;

    @Override
    public void validarePersoana(String cnpValidare) {
            try{
                File file = new File("D:\\Lucrari_JAVA\\Banca\\PersoaneExistente.txt");
                System.out.println(file.getCanonicalPath());
                FileInputStream ft = new FileInputStream(file);
                DataInputStream in = new DataInputStream(ft);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strline;
                HashMap<String, String> hashMap=new HashMap<>();
                List<String>personListBank=new ArrayList<>();///////////??????????????????????????
                while((strline = br.readLine()) != null){
                    String[] hashMapWrite=new String[2];
                    hashMapWrite[0]= Arrays.toString(new String[]{strline.split("\\s")[0]});
                    hashMapWrite[1]= Arrays.toString(new String[]{strline.split("\\s")[1]});
                    String hashM1=hashMapWrite[0];
                    String hashM2=hashMapWrite[1];
                    hashMap.put(hashM1, hashM2);
                }
                in.close();
                String var1="["+cnpValidare+"]";
                for(String validPerson:hashMap.keySet()){
                    if(var1.equals(validPerson)){
                        personListBank.add(hashMap.get(validPerson));
                        validare=true;
                    }
                }
                for(String s: personListBank) {
                    validKey=s;
                }
                if(validare){
                    System.out.println("Dumnevoastra aveti deja un cont la banca "+ validKey);
                }
                else {
                    System.out.println("Nu sunteti inregistrat/a la nici o banca doriti sa creati un cont ?");
                    contInexistent=true;
                    Scanner scanner2=new Scanner(System.in);
                    System.out.println("y-da/n-nu");
                    System.out.print("alegeti: "); String var2=scanner2.nextLine();
                    if (var2.equals("y")) {
                        Cont cont = new ContLei();
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.print("introduceti cnp: ");
                        String cnp = scanner3.nextLine();
                       // System.out.print("introduceti banca: ");
                        String bank = cont.getBanca();
                        RegistrarePersoana registrarePersoana = new RegistrarePersoana();
                        registrarePersoana.addPersonGeneralDoc(cnp, bank);
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.print("Introduceti nume: ");
                        cont.setNume(scanner4.nextLine());
                        System.out.print("Introduceti prenume: ");
                        cont.setPrenume(scanner4.nextLine());
                        System.out.print("Introduceti adresa de domiciliu: ");
                        cont.setDomiciliu(scanner4.nextLine());
                        cont.setCnp(cnp);
                        ContLei contLei=new ContLei();
                        contLei.contLei(cont);
                    }
                }
                validare=false;
                validKey=null;
            }catch(Exception e){
                System.err.println("Error: " + e.getMessage());
            }
    }
}
