package metodologie;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;


public class AppTest extends TestCase
{
	private static final String branch1 = "cartella/sotto-cartella-a-1/sotto-cartella-a-2/sotto-cartella-a-3";
	private static final String branch2 = "cartella/sotto-cartella-b-1/sotto-cartella-b-2";
	private static final String branch3 = "cartella/sotto-cartella-b-1";
	private static final String branch4 = "cartella/sotto-cartella-c-1";
	
	
	private void creaCartella() throws IOException {
		
		File c1 = new File(branch1);
		c1.mkdirs();
		File c2 = new File(branch2);
		c2.mkdirs();
		File c3 = new File(branch4);
		c3.mkdirs();
		
		File fa1 = new File(branch1 + "/text1.txt");
		File fa2 = new File(branch1 + "/text2.txt");
		File fa3 = new File(branch1 + "/img1.png");
		fa1.createNewFile();
		fa2.createNewFile();
		fa3.createNewFile();
		
		File fb1 = new File(branch2 + "/text3.txt");
		File fb2 = new File(branch2 + "/data.csv");
		fb1.createNewFile();
		fb2.createNewFile();
		
		File fb3 = new File(branch3 + "/text4.txt");
		File fb4 = new File(branch3 + "/img2.png");
		fb3.createNewFile();
		fb4.createNewFile();
		
		File fc1 = new File(branch4 + "/text5.txt");
		File fc2 = new File(branch4 + "/photo.jpg");
		fc1.createNewFile();
		fc2.createNewFile();
		
	}
	
	@org.junit.Test
    public void testCercaFile1() throws IOException {
		creaCartella();
    	assertEquals(Cartella.cercaFile(new File("cartella"), "text5.txt"), true);
    }
	
	@org.junit.Test
    public void testCercaFile2() throws IOException {
		creaCartella();
    	assertEquals(Cartella.cercaFile(new File("cartella"), "img2.png"), true);
    }
	
	@org.junit.Test
    public void testCercaFile3() throws IOException {
		creaCartella();
    	assertEquals(Cartella.cercaFile(new File("cartella"), "no.png"), false);
    }
	
	@org.junit.Test
    public void testCercaEstensione1() throws IOException {
		
		creaCartella();
		Set<File> s = Set.of(new File(branch1 + "/text1.txt"), new File(branch1 + "/text2.txt"), 
				new File(branch2 + "/text3.txt"), new File(branch3 + "/text4.txt"), new File(branch4 + "/text5.txt"));
				
    	assertEquals(Cartella.cercaEstensione(new File("cartella"), ".txt"), s);
    }
	
	@org.junit.Test
    public void testCercaEstensione2() throws IOException {
		
		creaCartella();
		Set<File> s = Set.of(new File(branch1 + "/img1.png"), new File(branch3 + "/img2.png"));
				
    	assertEquals(Cartella.cercaEstensione(new File("cartella"), ".png"), s);
    }
	
	@org.junit.Test
    public void testCercaEstensione3() throws IOException {
		
		creaCartella();
		Set<File> s = new HashSet<File>();
				
    	assertEquals(Cartella.cercaEstensione(new File("cartella"), ".boh"), s);
    }
	
	@org.junit.Test
    public void testCercaEstensioneBonus() throws IOException {
		
		creaCartella();
		Set<File> s = Set.of(new File(branch1 + "/text1.txt"), new File(branch1 + "/text2.txt"), 
				new File(branch2 + "/text3.txt"), new File(branch3 + "/text4.txt"), new File(branch4 + "/text5.txt"),
				new File(branch1 + "/img1.png"), new File(branch3 + "/img2.png"));
				
    	assertEquals(Cartella.cercaEstensione(new File("cartella"), List.of(".txt", ".png")), s);
    }
	
	@org.junit.Test
    public void testToString() throws IOException {
		
		creaCartella();
		Cartella c = new Cartella("cartella");
    	assertEquals(c.toString(), 
    			"cartella[ sotto-cartella-a-1[ sotto-cartella-a-2[ sotto-cartella-a-3[ img1.png text1.txt text2.txt ] ] ]"
    			+ " sotto-cartella-b-1[ img2.png sotto-cartella-b-2[ data.csv text3.txt ] text4.txt ]"
    			+ " sotto-cartella-c-1[ photo.jpg text5.txt ] ]");
    }
	
	
}
