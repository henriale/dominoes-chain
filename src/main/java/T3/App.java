package T3;

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

        try {
            dominoesAreChainable(new Chain(), boneyard);
        } catch (Exception e) {
            System.out.println("Shit was done: ");
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param chain sequence of dominoes
     * @param boneyard all dominoes not in chain
     *
     * @return boolean
     */
    private static boolean dominoesAreChainable(Chain chain, LinkedList<Domino> boneyard) throws Exception {
        if (boneyard.isEmpty()) {
            return true;
        }

        for (Domino domino: boneyard) {
            if (chain.dominoIsAttachable(domino)) {
                chain.attachDomino(domino);
                boneyard.remove(domino);
                return dominoesAreChainable(chain, boneyard);
            }
        }

        return false;
    }
}
