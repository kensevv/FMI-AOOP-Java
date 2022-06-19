package sequence;

public class Sequence {
    // Holds a sequence of Objects.
    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }
    public void add(Object x) {
        if(next < obs.length) {
            obs[next] = x;
            next++;
        }
    }
    private class Sselector implements Selector {// inner class манипулира преместване от първия към последния
        int i = 0;
        public boolean end() {
            return i == obs.length;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i < obs.length) i++;
        }
    } // end of inner class
    public Selector getSelector() {
        return new Sselector();
    }
    private class Rselector implements Selector {// inner class манипулира преместване от първия към последния
        int i = next - 1;
        public boolean end() {
            return i == -1;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i >= 0) i--;
        }
    } // end of inner class

    public Selector getRSelector() {
        return new Rselector();
    }

    public static void main(String[] args) {
// (1)създайте Sequence последователност от 8 елемента
// (2)инициализирайте Sequence елементите
// със случайни цели числа от интервала [10, 100]
// (3)използвайте метода getSelector(),за да разпечатате
// тези числа на конзолата
// от първия до последния елемент на последователността
// (4)използвайте метода getRSelector(),за да разпечатате
// на конзолата тези числа
// от последния елемент до първия на последователността
    }
}
