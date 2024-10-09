package Eleicao;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class server implements votos {
	
	public server() {		
	}
	
	static Map<String, Integer> boletim = new HashMap<>();
	
	@Override
	public boolean voto(String nome) throws RemoteException {
		if(nome != "") {
			if(boletim.get(nome) != null) {
				int votos = boletim.get(nome);
				votos += 1;
				boletim.put(nome, votos);
			}else {
				boletim.put(nome, 1);
			}
			return true;
		}else 
			return false;
	}
	
	

	 public static void main(String[] args) {
		 try {
	            
	            server s = new server();
	            
	            votos stub = (votos)UnicastRemoteObject.exportObject(s, 0);           
	            
	            Registry registro = LocateRegistry.createRegistry(1099);
	            
	            registro.rebind("Votacao", stub);            
	            
	            System.out.println("Servidor RMI está pronto!");
	            
	            Timer t = new Timer();
	            t.schedule(new TimerTask() {

					@Override
					public void run() {
						System.out.println("Apuração dos votos: ");
						for(String key : boletim.keySet()) {
							Integer value = boletim.get(key);
							System.out.print(key +"="+value +" | ");
						}
						System.out.println("");
					}
	            	
	            }, 0 ,5000);
	            
	            
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	 }

	
}
