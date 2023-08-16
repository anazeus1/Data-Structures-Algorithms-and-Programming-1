public class JavaStar {
    public static void main(String[] args) {
        rearrangePots(3, 0, 2);
        int[] containers = { 90, 20, 14, 11, 5, 19, 22 };
        existBalanceUpto(containers, 16, 0, 0);
        System.out.println('r');

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

}