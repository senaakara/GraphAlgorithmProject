import java.lang.*;
class Dijkstra {
    static final int V = 9;
    public int minFarkBul(int[] fark, Boolean[] finalList)
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++)
            if (!finalList[v] && fark[v] <= min) {
                min = fark[v];
                minIndex = v;
            }
        return minIndex;
    }
    public void printSolution(int[] fark)
    {
        System.out.println("Kaynağın köşeye uzaklığı: ");
        for (int i = 0; i < V; i++)
            System.out.println(i + ". köşeye olan uzaklığı --> " + fark[i]);
    }
    public void dijkstra(int[][] cizge, int kaynak)
    {
        int[] fark = new int[V];
        Boolean[] finalList = new Boolean[V];
        for (int i = 0; i < V; i++) {
            fark[i] = Integer.MAX_VALUE;
            finalList[i] = false;
        }
        fark[kaynak] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minFarkBul(fark, finalList);
            finalList[u] = true;
            for (int v = 0; v < V; v++)
                if (!finalList[v] && cizge[u][v] != 0 &&
                        fark[u] != Integer.MAX_VALUE && fark[u] + cizge[u][v] < fark[v])
                    fark[v] = fark[u] + cizge[u][v];
        }
        printSolution(fark);
    }
}