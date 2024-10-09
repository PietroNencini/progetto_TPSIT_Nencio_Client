package it.nencini;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Client pronto a collegarsi");

        Socket myClientSocket = new Socket("localhost", 5763);      // localhost: 127.0.0.1

        BufferedReader in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(myClientSocket.getOutputStream());

        String sending_string = "Ciao server!";
        out.writeBytes(sending_string + '\n');

        String edited_string = in.readLine();


        System.out.println("Il client si è collegato con successo!");
        System.out.println("stringa modificata dal server: " + edited_string);


        myClientSocket.close();



    }
}