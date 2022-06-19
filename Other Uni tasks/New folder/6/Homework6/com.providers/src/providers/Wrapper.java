package providers;

import services.Cipherable;

import java.util.Random;

import static java.lang.System.*;

public class Wrapper {
    private int size;

    public Wrapper(){
        size = 0;
    }

    public Wrapper(int size){
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size > 0 && size <= 100 ? size : 0;
    }

    private class FixedRandom implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random(seed);
            char[] returnedArray = new char[size];

            for(int i = 0; i < size; i++){
                char randChar = (char)(random.nextInt(26) + 'A');
                returnedArray[i] = (char)(randChar);
            }
            return returnedArray;
        }
    }

    private class FixedSelection implements Cipherable{
        private Random random = new Random();

        @Override
        public char[] getSecretChars(int seed) {
            char[] returnedArray = new char[size];

            for(int i = 0; i < size; i++){
                char randChar = (char)(random.nextInt(26) + 'A');
                returnedArray[i] = (char)(randChar);
            }
            return returnedArray;
        }
    }

    public FixedRandom makeFixedSelection(){
        return new FixedRandom();
    }

    public FixedSelection makeFixedRandom(){
        return new FixedSelection();
    }
}
