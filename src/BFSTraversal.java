import java.util.*;
public class BFSTraversal
{
    private final int dugum;
    private final LinkedList<Integer>[] bitisikListe;
    private final Queue<Integer> kuyruk;
    public BFSTraversal(int v)
    {
        dugum = v;
        bitisikListe = new LinkedList[dugum];
        for (int i=0; i<v; i++)
        {
            bitisikListe[i] = new LinkedList<>();
        }
        kuyruk = new LinkedList<>();
    }
    public void kenarEkleBFS(int v, int w)
    {
        bitisikListe[v].add(w);
    }
    public void BFS(int n)
    {
        boolean[] dugumler = new boolean[dugum];
        int a ;
        dugumler[n]=true;
        kuyruk.add(n);
        while (kuyruk.size() != 0)
        {
            n = kuyruk.poll();
            System.out.print(n+" ");
            for (int i = 0; i < bitisikListe[n].size(); i++)
            {
                a = bitisikListe[n].get(i);
                if (!dugumler[a])
                {
                    dugumler[a] = true;
                    kuyruk.add(a);
                }
            }
        }
    }
}