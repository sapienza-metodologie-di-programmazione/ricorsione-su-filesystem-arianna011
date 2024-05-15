package metodologie;

import java.io.File;
import java.util.HashSet;
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
    	cartella = new File(percorso);
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e un nome di file;
     * restituisce true se trova il file nella cartella (o in sue sotto-cartelle), false altrimenti
     */
    public static boolean cercaFile(File dir, String s) {
    	
    	for (File f : dir.listFiles())
    	{
    		if (f.isFile() && f.getName().equals(s)) return true;
    		if (f.isDirectory()) 
    		{
    			if (cercaFile(f, s)) return true;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e un'estensione di file;
     * restituisce un insieme dei file con tale estensione presenti nella cartella 
     * (eventualmente un insieme vuoto)
     */
    public static Set<File> cercaEstensione(File dir, String e) {
    	
    	HashSet<File> s = new HashSet<File>();
    	
    	for (File f : dir.listFiles())
    	{
    		if (f.isFile())
    		{
    			int i = f.getName().lastIndexOf('.');
    			String ext = f.getName().substring(i);
    			if (ext.equals(e))
    				s.add(f);
    		}
    			
    		if (f.isDirectory()) 
    		{
    			s.addAll(cercaEstensione(f, e));
    		}
    	}
    	
    	return s;
    }
    
    /**
     * Metodo ricorsivo che prende in input una cartella e una lista di estensioni di file;
     * restituisce un insieme dei file con tali estensioni presenti nella cartella 
     * (eventualmente un insieme vuoto)
     */
    public static Set<File> cercaEstensione(File dir, List<String> es) {
    	
    	Set<File> s = new HashSet<File>();
    	
    	for (File f : dir.listFiles())
    	{
    		if (f.isFile())
    		{
    			int i = f.getName().lastIndexOf('.');
    			String ext = f.getName().substring(i);
    			if (es.contains(ext))
    				s.add(f);
    		}
    			
    		if (f.isDirectory()) 
    		{
    			s.addAll(cercaEstensione(f, es));
    		}
    	}
    	
    	return s;
    }
    
    
    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(cartella.getName()+"[ ");
    	for (File f : cartella.listFiles()) 
    	{
    		if (f.isFile()) sb.append(f.getName()+" ");
    		if (f.isDirectory()) sb.append(new Cartella(f.getPath()).toString()+" ");
    	}
    	sb.append("]");
    	
    	return sb.toString();
    }
    
    
}

