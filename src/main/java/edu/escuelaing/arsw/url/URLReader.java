package edu.escuelaing.arsw.url;

import java.io.*;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL(args[0]);
        String direccion = "pagina.html";
        File archivo = new File(direccion);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        try { BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = null;
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            while ((inputLine = reader.readLine()) != null){
                bw.write(inputLine);
                System.out.println(inputLine);
            }
            bw.close();
        }catch (IOException x){
            System.err.println(x);
        }
    }
}
