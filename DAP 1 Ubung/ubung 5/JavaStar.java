import java.util.Arrays;

public class JavaStar {
    public static void main(String[] args) {
        rearrangePots(3, 0, 2);
        int[] containers = { 5, 5, 4, 6, 30 };
        boolean r = existsBalanceWith3Limited(containers, 90, 0, 0, 0, 0, 0, 2);
        System.out.println(r);

    }

    public static void rearrangePots(int quantity, int start, int target) {
        String[] locations = { "stove", "cupboard", "sink" };
        if (quantity > 0) {
            rearrangePots(quantity - 1, start, countInterimPosition(start, target));
            System.out.println("pot" + quantity + ": " + locations[start] + " -> " + locations[target]);
            rearrangePots(quantity - 1, countInterimPosition(start, target), target);

        }
    }

    private static int countInterimPosition(int start, int target) {
        return 3 - start - target;
    }

    private static boolean existBalanceUpto(int[] conatiners, int limit, int divergence, int unitsLoaded) {
        if (conatiners.length <= unitsLoaded) {
            return true;

        }
        int nextDivergence = divergence + conatiners[unitsLoaded];
        if (Math.abs(nextDivergence) <= limit) {
            boolean loadOnPortSite = existBalanceUpto(conatiners, limit, nextDivergence, unitsLoaded + 1);
            if (loadOnPortSite) {
                return true;
            }

        }
        nextDivergence = divergence - conatiners[unitsLoaded];
        if (Math.abs(nextDivergence) <= limit) {
            return existBalanceUpto(conatiners, limit, nextDivergence, unitsLoaded + 1);

        }
        return false;

    }

    public static boolean existTotalBalance(int[] containers, int limit, int divergence, int position) {
        if (position >= containers.length) {
            if (divergence == 0) {
                return true;
            }
            return false;
        }

        int nextDivergence = divergence + containers[position];
        if (Math.abs(nextDivergence) <= limit) {
            boolean loadOnPortSite = existTotalBalance(containers, limit, nextDivergence, position + 1);
            if (loadOnPortSite) {
                return true;
            }

        }
        nextDivergence = divergence - containers[position];
        if (Math.abs(nextDivergence) <= limit) {
            return existTotalBalance(containers, limit, nextDivergence, position + 1);

        }
        return false;
    }

    public static boolean existsBalanceWith3Limited(int[] containers, int limit, int divergence, int position,
            int nbRecht, int nbLink, int nbMiddle, int maximal) {
        if (nbRecht > maximal || nbLink > maximal || nbMiddle > maximal) {
            if (position >= containers.length) {
                if (divergence == 0)
                    return true;
            }
            return false;
        }

        int newDivergence = divergence + containers[position];
        if (Math.abs(newDivergence) <= limit) {
            boolean a = existsBalanceWith3Limited(containers, limit, newDivergence, position + 1, nbRecht + 1, nbMiddle,
                    nbLink, 1);
            if (a) {
                return true;
            }
        }
        newDivergence = divergence - containers[position];
        if (Math.abs(newDivergence) <= limit) {
            boolean b = existsBalanceWith3Limited(containers, limit, newDivergence, position + 1, nbRecht, nbLink + 1,
                    nbMiddle, 1);
            if (b) {
                return true;
            }
        }
        if (Math.abs(divergence) <= limit) {
            return existsBalanceWith3Limited(containers, limit, divergence, position + 1, nbRecht, nbLink,
                    nbMiddle + 1, 1);
        }
        return false;

    }

  

}