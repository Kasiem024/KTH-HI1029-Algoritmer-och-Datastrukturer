package NB16;

public class NB16Main {

    public static void main(String[] args) {

        Queue<State> q = new Queue<>();
        State t = new State(5, 1, 3, 0);

        while ((t.blue != t.white || t.blue != t.red) && t.nrSwitches < 16) {
            if (t.blue > 0) q.offer(new State(t.blue - 1, t.white + 1, t.red + 3, t.nrSwitches + 1));
            if (t.white > 0) q.offer(new State(t.blue + 2, t.white - 1, t.red + 4, t.nrSwitches + 1));
            if (t.red > 0) q.offer(new State(t.blue + 1, t.white + 5, t.red - 1, t.nrSwitches + 1));

            if (q.isEmpty()) break;
            t = q.poll();
        }

        System.out.println(t.nrSwitches);
    }

    private static class State {
        public int blue, white, red, nrSwitches;

        public State(int blue, int white, int red, int nrSwitches) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.nrSwitches = nrSwitches;
        }
    }
}
