package metodologie;

import java.io.File;
import java.util.List;
import java.util.Set;


/**
 * Classe che rappresenta una cartella del file system
 */
public class Cartella 
{
    private File cartella;
    
    public Cartella(String percorso) 
    {
    	//implementare
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e un nome di file;
     * restituisce true se trova il file nella cartella (o in sue sotto-cartelle), false altrimenti
     */
    public static boolean cercaFile(File dir, String s) {
    	
    	//implementare
    	return false;
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e un'estensione di file;
     * restituisce un insieme dei file con tale estensione presenti nella cartella 
     * (eventualmente un insieme vuoto)
     */
    public static Set<File> cercaEstensione(File dir, String e) {
    	
    	//implementare
    	return null;
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e una lista di estensioni di file;
     * restituisce un insieme dei file con tali estensioni presenti nella cartella 
     * (eventualmente un insieme vuoto)
     */
    public static Set<File> cercaEstensione(File dir, List<String> es) {
    	
    	//implementare
    	return null;
    }
    
    
    @Override
    public String toString() {
    	
    	//implementare
    	return null;
    }
    
    
}
