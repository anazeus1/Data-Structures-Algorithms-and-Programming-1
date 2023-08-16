
public class GameOfLife {
    public static void main(String[] args) {
        /*
         * Die Elemente dieses Feldes werden als Zellen interpretiert werden, die leben
         * – dann besitzt das Element den
         * Wert true – oder tot sind – dann besitzt das Element den Wert false.
         */
        boolean[][] population = {
                { false, true, true, true },
                { true, true, true, false },
                { true, false, false, false },
                { true, true, false, false } };
        GameOfLife g1 = new GameOfLife(population.length);
        g1.futureGeneration(2);
        g1.show();

        System.out.println();
    }

    private boolean[][] population;

    public GameOfLife(int n) {
        population = new boolean[n][n];
    }

    // return the next state of a given cell
    private boolean nextState(int i, int j) {
        int nbAliveNeighbors = getAliveNeighbors(i, j);

        // if its dead and have 3 alive neighbors it becomes alive else it stays dead
        if (!population[i][j]) {
            if (nbAliveNeighbors == 3) {
                return true;
            }
            return false;
        }

        // if its alive and has 3 or 2 alive neighbors it stays alive else it becomes
        // dead

        if (nbAliveNeighbors < 2) {
            return false;
        }
        if (nbAliveNeighbors > 3) {
            return false;
        }
        return true;
    }

    public void nextGeneration() {
        boolean[][] newPopulation = new boolean[population.length][population[0].length];
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population[i].length; j++) {
                newPopulation[i][j] = nextState(i, j);

            }
        }
        population = newPopulation;
    }

    public void futureGeneration(int n) {
        for (int i = 0; i < n; i++) {
            nextGeneration();
        }

    }

    public void show() {
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population[i].length; j++) {
                System.out.print(" | " + population[i][j]);

            }
            System.out.println();
        }
    }

    public int getAliveNeighbors(int i, int j) {
        int nbAliveNeighbors = 0;
        for (int x = i - 1; x < i + 2; x++) {
            for (int y = j - 1; y < j + 2; y++) {

                // if its not out of array bound
                if (x >= 0 & x < population.length & y >= 0 & y < population[i].length) {

                    // if its not the same cell and alive we add it
                    if (!(x == i & y == j)) {
                        if (population[x][y]) {
                            nbAliveNeighbors++;
                        }

                    }

                }
            }
        }

        return nbAliveNeighbors;

    }

}