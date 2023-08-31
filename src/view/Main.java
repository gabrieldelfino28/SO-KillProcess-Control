package view;

import controller.KillControl;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        KillControl kc = new KillControl();
        String Menu = "";
        do{
            Menu = JOptionPane.showInputDialog("Menu\n1- Lista Processos\n2- Mata Processos\n9 - Fim");
            switch(Menu){
                case "1" -> kc.ProcessList();
                case "2" -> kc.KillProcess();
                case "9" -> {
                    JOptionPane.showMessageDialog(null,"Saindo");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null,"Valor inválido tente novamente");
            }
        }while(true);
    }
}
