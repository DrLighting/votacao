package Eleicao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
	
	
	public static void main(String[] args) {
		 
		 
		 try {
	            
	            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
	            votos stub = (votos) registro.lookup("Votacao");
	            
	            Scanner voto = new Scanner(System.in);
	            System.out.println("Digite o Nome do candidato: ");
	            String nome  = voto.nextLine();
	            
	            if(stub.voto(nome)) {
	            	System.out.println("Seu voto foi registrado");
	            }else {
	            	System.out.println("Erro na votação");
	            }
	            
	           
	            
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}
}
