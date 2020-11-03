package com.mishafauzel;

import com.mishafauzel.io.CommandLineController;
//Главный класс, контролирует основной поток выполнения
public class Main {
    private static CommandLineController commandLineController=new CommandLineController();


    public static void main(String[] args) {
	    commandLineController.showHelloString();
	    commandLineController.readInputString();


    }
}
