package T3;

import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextInt();

        LinkedList<Domino> boneyard = new LinkedList<Domino>();

        boneyard.add(new Domino(4, 5));
        boneyard.add(new Domino(1, 2));
        boneyard.add(new Domino(2, 3));
        boneyard.add(new Domino(3, 4));

        dominoesAreChainable(boneyard, new Chain());
    }

    private static boolean dominoesAreChainable(LinkedList<Domino> boneyard, Chain chain) {
        if (boneyard.isEmpty()) {
            return true;
        }
        // boneyard: D[4,5] A[1,2] B[2,3] C[3,4]
        // chain: {}
        // -------------
        // boneyard: A[1,2] B[2,3] C[3,4]
        // chain: {D}

        // TODO: move into the foreach
        Domino domino = boneyard.removeFirst();
        // boneyard: A[1,2] B[2,3] C[3,4]
        // aux: D
        // chain: {}
        // -------------
        // boneyard: B[2,3] C[3,4]
        // aux: A
        // chain: {D}

        // @TODO: add foreach
        if (chain.dominoIsAttachable(domino)) {
            // boneyard: A[1,2] B[2,3] C[3,4]
            // aux: D
            // chain: {D}
            // -------------
            // boneyard: A[1,2] B[2,3]
            // aux: C
            // chain: {C,D}

            dominoesAreChainable(boneyard, chain);
        } else {
            boneyard.addLast(domino);
            return false;
            //dominoesAreChainable(boneyard, chain);
        }

        return true;
    }
}
