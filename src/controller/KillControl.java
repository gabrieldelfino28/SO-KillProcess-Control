package controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillControl {
    public KillControl() {
        super();
    }

    private String SOIdentify() {
        return System.getProperty("os.name");
    }

    public void ProcessList() {
        String process = "";
        String OS = SOIdentify();

        if (OS.contains("Windows")) {
            process = "TASKLIST /FO TABLE";
        } else { //Linux
            process = "ps -ef";
        }

        try {
            Process TaskList = Runtime.getRuntime().exec(process);
            InputStream fluxo = TaskList.getInputStream();
            InputStreamReader reader = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(reader);

            String Linha = buffer.readLine();
            while (Linha != null) {
                System.out.println(Linha);
                Linha = buffer.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void KillProcess() {
        String process = "";

        String OS = SOIdentify();
        StringBuilder buffer = new StringBuilder();

        if (OS.contains("Windows")) {
            String cmdPid = "TASKKILL /PID ";
            String cmdNome = "TASKKILL /IM ";
            int PID=0;
            try {
                process = JOptionPane.showInputDialog("Informe o PID ou Nome do processo: ");
                PID = Integer.parseInt(process);
                buffer.append(cmdPid).append(PID);

            } catch (Exception e) {
                buffer.append(cmdNome).append(process);
            }

        } else { //Linux
            String terminalPID = "kill -9 ";
            String terminalName = "pkill -f ";
            int PID=0;
            try {
                process = JOptionPane.showInputDialog("Informe o PID ou Nome do processo: ");
                PID = Integer.parseInt(process);
                buffer.append(terminalPID).append(PID);

            } catch (Exception e) {
                buffer.append(terminalName).append(process);
            }
        }

        try {
            Runtime.getRuntime().exec(buffer.toString());
        }catch(IOException io){
            io.printStackTrace();
        }


    }

}
