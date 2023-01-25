package thread;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculadora extends Thread{

    int[] num;
    PrintWriter out;
    BufferedReader in;
    String inputLine;

    public Calculadora(int[] num, PrintWriter out, BufferedReader in, String inputLine) {
        this.num = num;
        this.out = out;
        this.in = in;
        this.inputLine = inputLine;
    }

    boolean check = true;

    @Override
    public void run() {

        System.out.println("ENTRA");
        switch (inputLine){
            case "SUMA":
                suma();
                break;
            case "RESTA":
                resta();
                break;
            case "MULTI":
                multi();
                break;
            case "DIV":
                div();
                break;
            case "EXIT":
                try {
                    exit();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                out.println("LOS COMANDOS ACEPTADOS SON: " + "/n" + "SUMA, RESTA, MULTI, DIV Y EXIT");
        }

        this.stop();

    }

    private  void entrada(){
        try {
            out.println("INTRODUCE NUM1: ");
            num [0] = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println("INTRODUCE NUM2: ");
        try {
            num [1] = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void exit() throws IOException {
        if (in.readLine().equals("EXIT")){
            check = false;
        }
    }
    private void suma(){
        entrada();
        int total = num[0] + num[1];
        out.println("TOTAL: " + total);
    }

    private void resta(){
        System.out.println("entra en resta");
        entrada();
        int total = num[0] - num[1];
        out.println("TOTAL: " + total);
    }

    private void multi(){
        entrada();
        int total = num[0] * num[1];
        out.println("TOTAL: " + total);
    }

    private void div(){
        entrada();
        int total = num[0] / num[1];
        out.println("TOTAL: " + total);
    }
}
