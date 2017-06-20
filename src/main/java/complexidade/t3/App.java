package complexidade.t3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String DEFAULT_FILENAME = "input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = DEFAULT_FILENAME;
        if (args.length > 1 && args[0].equals("--filename")) {
            inputFile = args[1];
        }

        Scanner scanner = new Scanner(new FileInputStream(inputFile));
        LinkedList<Domino> boneyard = new LinkedList<>();

        if (! scanner.hasNextInt()) {
            throw new InvalidParameterException("Number of dominoes not specified");
        }

        int n = scanner.nextInt();
        for (int i=0; i < n; i++) {
            if (! scanner.hasNextInt()) {
                throw new InvalidParameterException("Number of dominoes should be exactly " + n);
            }

            boneyard.add(new Domino(scanner.nextInt(), scanner.nextInt()));
        }

        try {
        	Chain chain = new Chain();
        	if (dominoesAreChainable(chain, boneyard)) {
                System.out.println(chain);
            } else {
        	    System.out.println("Dominoes are not a chain");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Shit was done: " + e.getMessage());
        }
    }

    /**
     *
     * @param chain sequence of dominoes
     * @param boneyard all dominoes not in chain
     *
     * @return boolean informando se é possível encadear todos os dominós ou não.
     */
    public static boolean dominoesAreChainable(Chain chain, List<Domino> boneyard) throws InvalidParameterException {
        if(isEmpty(boneyard)) return true;

        for(Domino domino: boneyard) {
            if(!domino.wasUsed() && chain.dominoIsAttachable(domino)) {
                domino.setUsed(true); 
                chain.attachDomino(domino);
                if(dominoesAreChainable(chain, boneyard)) {
                    return true;
                } else {
                	chain.detachDomino(domino);
                	domino.setUsed(false);
                }
            } 
        }

        return false;
    }
    
    private static boolean isEmpty(List<Domino> boneyard) {
    	if(boneyard.isEmpty()) return true;
    	for(Domino domino: boneyard) {
    		if(!domino.wasUsed()) return false;
    	}
    	return true;
    }
}
