package edu.escuelaing.arsw.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class ServidorCalculadora {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35002);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35002.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        String funcion = "cos";
        double resultado = 0;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.equals("fun:sin")){
                funcion = "sin";
            }else if(inputLine.equals("fun:cos")){
                funcion = "cos";
            }else if(inputLine.equals("fun:tan")){
                funcion = "tan";
            }else{
                double numero = conversion(inputLine);
                if(funcion.equals("sin")){
                    resultado = sin(numero);
                }else if(funcion.equals("cos")){
                    resultado = cos(numero);
                }else if(funcion.equals("tan")){
                    resultado = tan(numero);
                }
            }
            DecimalFormat formato2 = new DecimalFormat("0.0#");
            System.out.println("Mensaje: " + inputLine);
            outputLine = String.valueOf(formato2.format(resultado));
            out.println(outputLine);
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static double sin(double num){
        double sin = Math.sin(num);
        return sin;
    }
    private static double conversion(String num){
        String numerador = "";
        String denominador = "";
        boolean mult = true;
        double n = 1;
        if(num.equals("π")){
            n = Math.PI;
            return n;
        }else if(num.equals("0")){
            n = 0;
            return n;
        }else if(num.equals("π/2")){
            return Math.PI/2;
        }else if(num.equals("3π/2")){
            return (3*Math.PI)/2;
        }else if(num.equals("2π")){
            return 2*Math.PI;
        }
        for (char c: num.toCharArray ()) {
            if(c == 'π'){
                if(!numerador.equals("")){
                    n = Double.parseDouble(numerador);
                }
                n = n*Math.PI;
            }else if(c == '/') {
                mult = false;
            }else if(mult){
                numerador += c;
            }else{
                denominador += c;
            }
        }
        if(!denominador.equals("")){
            n = n/Double.parseDouble(denominador);
        }
        return n;
    }

    private static double cos(double num){
        double cos = Math.cos(num);
        return cos;
    }

    private static double tan(double num){
        double tan = Math.tan(num);
        return tan;
    }
}
