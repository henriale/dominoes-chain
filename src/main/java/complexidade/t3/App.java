package complexidade.t3;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LinkedList<Domino> boneyard = new LinkedList<Domino>();

        boneyard.add(new Domino(4, 5));
        boneyard.add(new Domino(1, 4));
        boneyard.add(new Domino(2, 5));
        boneyard.add(new Domino(3, 2));
        boneyard.add(new Domino(3, 3));
        boneyard.add(new Domino(4, 1));
        boneyard.add(new Domino(3, 0));
        boneyard.add(new Domino(0, 0));
        boneyard.add(new Domino(0, 0));
        boneyard.add(new Domino(1, 0));

        try {
        	Chain myChain = new Chain();
        	System.out.println("Result: " + dominoesAreChainable(myChain, boneyard));
        	System.out.println(myChain);
        } catch (InvalidParameterException ex) {
            System.out.println("Shit was done: " + ex.getMessage());
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
