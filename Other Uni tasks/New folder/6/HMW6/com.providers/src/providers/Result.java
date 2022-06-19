package providers;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data){
        this.chars = chars;
        this.data = data;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String toString(){
        int charsLength = chars.length;
        String returnedString = "The data is: " + data + "\n";
        for(int i = 0; i < charsLength; i++){
            returnedString += chars[i] + "\n";
        }

        return returnedString;
    }
}
