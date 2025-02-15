package by.it.group151051.k_maliuk.lesson12;

import java.util.Arrays;

public class TaskB
{
    static final int INF = 100000;
    public int[][] matr = {
            { INF, 4,   -2,  INF, INF, INF, INF, INF, INF, INF },
            { INF, INF, INF, INF, INF, INF, -2 , -4 , INF, INF },
            { INF, INF, INF, 2  , INF, 1  , INF, INF, INF, INF },
            { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF },
            { INF, INF, INF, INF, INF, -2 , INF, 3  , INF, INF },
            { INF, INF, INF, 3  , INF, INF, INF, INF, INF, INF },
            { INF, INF, INF, INF, INF, INF, INF, INF, -1 , INF },
            { INF, INF, INF, INF, INF, INF, 1  , INF, INF, INF },
            { INF, INF, INF, INF, INF, INF, INF, 1  , INF, INF },
            { 7  , INF, 6  , INF, 6  , 5  , INF, INF, INF, INF }
    };
    public int[] dist = new int[10];
    public int[] path = new int[10];

    public void Bellman_Ford(int temp)
    {
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);
        dist[temp] = 0;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    if ((dist[k] > dist[j] + matr[j][k]) && matr[j][k] != INF)
                    {
                        dist[k] = dist[j] + matr[j][k];
                        path[k] = j;
                    }
    }

    public void printPath(int a, int b)
    {
        if (a == b) System.out.print( (a) + " ");
        else
        {
            if (path[b] == -1) System.out.println("No path from " + (a) + " to " + (b));
            else
            {
                printPath(a, path[b]);
                System.out.print(b + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        TaskB graph = new TaskB();
        graph.Bellman_Ford(1);

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Shortest path from 1 to " + i + ": " );
            graph.printPath(1, i);
            System.out.println("\nDistance: " + graph.dist[i]);
        }
    }
}