package edu.escuelaing.arsw.url;

import java.net.MalformedURLException;
import java.net.URL;


public class URLScanner
{
    public static void main( String[] args ) throws MalformedURLException
    {
        URL personalSite = new URL("https://ldbn.escuealing.edu.co:80/publicaciones/publicaciones.pdf?val=456r=78#publicaciones");
        System.out.println("Protocolo: " + personalSite.getProtocol());
        System.out.println("Authority: " + personalSite.getAuthority());
        System.out.println("Host: " + personalSite.getHost());
        System.out.println("Port: " + personalSite.getPort());
        System.out.println("Path: " + personalSite.getPath());
        System.out.println("Query: " + personalSite.getQuery());
        System.out.println("File: " + personalSite.getFile());
        System.out.println("Ref: " + personalSite.getRef());
    }
}
