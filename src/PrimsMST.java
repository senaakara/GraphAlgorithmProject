import java.lang.*;
class PrimsMST {
    private static final int kose = 5;
    public int minKey(int[] key, Boolean[] finalList)
    {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < kose; v++)
            if (!finalList[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        return minIndex;
    }
    public void printMST(int[] parent, int[][] cizge)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < kose; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + cizge[i][parent[i]]);
    }
    public void yazdirMST(int[][] cizge)
    {
        int[] parent = new int[kose];
        int[] key = new int[kose];
        Boolean[] finalList = new Boolean[kose];
        for (int i = 0; i < kose; i++) {
            key[i] = Integer.MAX_VALUE;
            finalList[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < kose - 1; count++) {
            int u = minKey(key, finalList);
            finalList[u] = true;
            for (int v = 0; v < kose; v++)
                if (cizge[u][v] != 0 && !finalList[v]
                        && cizge[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = cizge[u][v];
                }
        }

        printMST(parent, cizge);
    }
}