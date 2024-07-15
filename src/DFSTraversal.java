import java.util.*;
class DFSTraversal {
    private final int V;
    private final LinkedList<Integer>[] bitisikListe;


    @SuppressWarnings("unchecked")
    public DFSTraversal(int v)
    {
        V = v;
        bitisikListe = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            bitisikListe[i] = new LinkedList<>();
    }

    public void kenarEkleDFS(int v, int w)
    {
        bitisikListe[v].add(w);
    }

    public void DFSUtil(int v, boolean[] ziyaretEdilenler)
    {

        ziyaretEdilenler[v] = true;
        System.out.print(v + " ");

        for (int n : bitisikListe[v]) {
            if (!ziyaretEdilenler[n])
                DFSUtil(n, ziyaretEdilenler);
        }
    }

    public void DFS()
    {
        boolean[] ziyaretEdilenler = new boolean[V];
        DFSUtil(0, ziyaretEdilenler);
    }


}
