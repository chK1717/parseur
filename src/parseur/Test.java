package parseur;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		 
		        List<String> testChains = Arrays.asList(
		                "cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdbbcr", "cdcbbb", "cdcb", ""
		        );

		        for (String chain : testChains) {
		            RecursiveDescentParser parser = new RecursiveDescentParser(chain);
		            boolean result = parser.parse();
		            System.out.println("Chaîne: " + chain + " -> " + (result ? "Valide" : "Invalide"));
		        }
		    

	}

}
