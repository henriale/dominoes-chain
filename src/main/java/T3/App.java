package T3;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextInt();

        LinkedList<Domino> boneyard = new LinkedList<Domino>();

        boneyard.add(new Domino(4, 5));
        boneyard.add(new Domino(1, 2));
        boneyard.add(new Domino(2, 3));
        boneyard.add(new Domino(3, 4));

        boolean out = false;

        try {
            out = dominoesAreChainable(new Chain(), boneyard);
        } catch (InvalidParameterException e) {
            System.out.println("Shit was done: ");
            System.out.println(e.getMessage());
        }

        System.out.println("Dominoes are chainable: " + out);
    }

    /**
     *
     * @param chain sequence of dominoes
     * @param boneyard all dominoes not in chain
     *
     * @return boolean
     */
    private static boolean dominoesAreChainable(Chain chain, LinkedList<Domino> boneyard) throws InvalidParameterException {
        if (boneyard.isEmpty()) {
            return true;
        }

        boolean dominoesAreChainable;

        for (Domino domino: boneyard) {
            if (chain.dominoIsAttachable(domino)) {
                chain.attachDomino(domino);
                boneyard.remove(domino);
                dominoesAreChainable = dominoesAreChainable(chain, boneyard);
                if (dominoesAreChainable) {
                    return true;
                }

                // todo: detach dominoes from chain
            }
        }

        return false;
    }
}
