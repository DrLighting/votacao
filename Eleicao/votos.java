package Eleicao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface votos extends Remote {
	
	boolean voto (String nome) throws RemoteException;
	
	
}
