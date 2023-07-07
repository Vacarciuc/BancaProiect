import java.io.*;

public class RegistrarePersoana extends ValidarePersoanaExistente {

    public void addPersonGeneralDoc(String cnp, String bank) {
        try(FileWriter fw = new FileWriter("D:\\Lucrari_JAVA\\Banca\\PersoaneExistente.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            String str =cnp+" "+bank;
            out.println(str);
        } catch (IOException e) {
            ///
        }
    }
}
