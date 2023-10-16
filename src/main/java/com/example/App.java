package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String risposta = new String();

            do {
                System.out.print(in.readLine() + ": ");
                out.writeBytes(scanner.nextLine() + '\n');
                risposta = in.readLine();
                if (Integer.parseInt(risposta) == 1) {
                    System.out.println("il numero inserito è troppo grande");
                } else if (Integer.parseInt(risposta) == 2) {
                    System.out.println("il numero inserito è troppo piccolo");
                } else if (Integer.parseInt(risposta) == 3) {
                    System.out.println("hai indovinato, sei un figo con " + in.readLine() + " tentativi");
                }
            } while (Integer.parseInt(risposta) != 3);
            scanner.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }

    }
}