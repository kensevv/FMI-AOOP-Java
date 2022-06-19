package providers;

import services.Cipherable;

public class CipherGenerator {
        public static Result countDistinct(Cipherable cipher, int seed){
        char[] randomGeneratedChars = cipher.getSecretChars(seed);
        int notRepetebleChars = 0;
        int currValue = 0;

        int randomGeneratedCharsCount = randomGeneratedChars.length;
        for(int i = 0; i < randomGeneratedCharsCount; i++){
            char currChar = randomGeneratedChars[i];
            for(int j = 0; j < randomGeneratedCharsCount; j++){
                char nextChar = randomGeneratedChars[j];


                if(currChar == nextChar) currValue++;
            }
            if(currValue == 0) notRepetebleChars++;
            currValue = 0;
        }

        Result result = new Result(randomGeneratedChars, notRepetebleChars);

        return result;
    }
}
