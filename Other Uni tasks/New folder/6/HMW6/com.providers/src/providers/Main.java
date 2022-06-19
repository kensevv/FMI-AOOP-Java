package providers;

import services.Cipherable;

public class Main {

    public static void main(String[] args) {

        Wrapper wr = new Wrapper(8);
        Cipherable cp = wr.makeFixedSelection();

        CipherGenerator cg = new CipherGenerator();

        Result res = cg.countDistinct(cp, 8);

        char[] chars = res.getChars();
        int charsCount = chars.length;

        for(int i = 0; i < charsCount; i++){
            char charOne = chars[i];

            System.out.println(charOne);
        }

    }
}
