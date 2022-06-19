public class RouteCipherTEST {
    public static void main(String[] args) {
        // positive key test
        RouteCipher positiveCipher = new RouteCipher(5);
        System.out.println("Plain text: ABORT THE MISSION, YOU HAVE BEEN SPOTTED");
        System.out.println(String.format("Encrypted text with positive key = 5:\n %s",
                positiveCipher.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED")));

        // negative key test
        RouteCipher negativeCipher = new RouteCipher(-5);
        System.out.println(String.format("Encrypted text with negative key = -5:\n %s",
                negativeCipher.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED")));
    }
}