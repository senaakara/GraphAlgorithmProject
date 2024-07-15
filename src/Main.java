import java.util.Objects;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) {
        System.out.println("Huffman Encoding Tree: ");
        int n = 6;
        char[] karakterListe = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] karakterFreq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<HuffmanNode> kuyruk
                = new PriorityQueue<>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.c = karakterListe[i];
            node.data = karakterFreq[i];
            node.left = null;
            node.setRight(null);
            kuyruk.add(node);
        }
        HuffmanNode root = null;
        while (kuyruk.size() > 1) {
            HuffmanNode a = kuyruk.peek();
            kuyruk.poll();
            HuffmanNode b = kuyruk.peek();
            kuyruk.poll();
            HuffmanNode f = new HuffmanNode();

            if (b != null) {
                f.data = a.data + b.data;
            }
            f.c = '-';
            f.left = a;
            f.setRight(Objects.requireNonNull(b));
            root = f;
            kuyruk.add(f);
        }
        if (root == null) {
            throw new AssertionError();
        }
        Huffman.sifreYazdir(root, "");

        System.out.println("*******");


        int[][] cizge = new int[][]
                {       { 0, 8, 0, 0, 0, 0, 0, 8, 0 },
                        { 8, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Dijkstra enKisaUzaklik = new Dijkstra();
        System.out.println("Dijkstra’s Shortest Path: ");
        enKisaUzaklik.dijkstra(cizge, 4);

        System.out.println("*******");

        PrimsMST prims = new PrimsMST();
        int[][] cizge2 = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        System.out.println("Prims's Minimum Spanning Tree:");
        prims.yazdirMST(cizge2);

        System.out.println("*******");

        BFSTraversal bfs = new BFSTraversal(4);
        bfs.kenarEkleBFS(0, 1);
        bfs.kenarEkleBFS(0, 2);
        bfs.kenarEkleBFS(1, 2);
        bfs.kenarEkleBFS(2, 0);
        bfs.kenarEkleBFS(2, 3);
        bfs.kenarEkleBFS(3, 3);
        System.out.println("Çizge için Breadth First Traversal: ");
        bfs.BFS(0);
        System.out.println();
        System.out.println("*******");

        DFSTraversal dfs = new DFSTraversal(6);
        dfs.kenarEkleDFS(0, 1);
        dfs.kenarEkleDFS(0, 3);
        dfs.kenarEkleDFS(0, 4);
        dfs.kenarEkleDFS(4, 5);
        dfs.kenarEkleDFS(3, 5);
        dfs.kenarEkleDFS(1, 2);
        dfs.kenarEkleDFS(1, 0);
        dfs.kenarEkleDFS(2, 1);
        dfs.kenarEkleDFS(4, 1);
        dfs.kenarEkleDFS(3, 1);
        dfs.kenarEkleDFS(5, 4);
        dfs.kenarEkleDFS(5, 3);

        System.out.println("0.Köşeden Başlayarak Depth First Traversal: ");
        dfs.DFS();

        System.out.println();
        System.out.println("*******");


        Trie trie = new Trie();
        trie.kelimeEkle("ege");
        trie.kelimeEkle("bilgisayar");
        trie.kelimeEkle("data");
        trie.kelimeEkle("kod");
        trie.kelimeEkle("java");
        trie.kelimeEkle("python");
        System.out.println(trie.bulunduMu("ege"));
        System.out.println(trie.bulunduMu("bilgisayar"));
        System.out.println(trie.bulunduMu("data"));
        System.out.println(trie.bulunduMu("kod"));
        System.out.println(trie.bulunduMu("java"));
        System.out.println(trie.bulunduMu("python"));
        System.out.println(trie.bulunduMu("mühendis"));








    }
}