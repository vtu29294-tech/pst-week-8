import java.io.*;
import java.util.*;

public class Queue{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

int[] value = new int[n];
int[] color = new int[n];

for (int i = 0; i < n; i++) {
    value[i] = sc.nextInt();
}

for (int i = 0; i < n; i++) {
    color[i] = sc.nextInt();
}

@SuppressWarnings("unchecked")
ArrayList<Integer>[] graph = new ArrayList[n];

for (int i = 0; i < n; i++) {
    graph[i] = new ArrayList<>();
}

for (int i = 0; i < n - 1; i++) {
    int u = sc.nextInt() - 1;
    int v = sc.nextInt() - 1;

    graph[u].add(v);
    graph[v].add(u);
}

int[] parent = new int[n];
int[] depth = new int[n];
boolean[] leaf = new boolean[n];

Arrays.fill(parent, -1);

java.util.Queue<Integer> queue = new LinkedList<>();
queue.add(0);
parent[0] = -2;

while (!queue.isEmpty()) {

    int current = queue.poll();

    for (int next : graph[current]) {

        if (next != parent[current]) {

            parent[next] = current;
            depth[next] = depth[current] + 1;

            queue.add(next);
        }
    }
}

for (int i = 0; i < n; i++) {

    if (i != 0 && graph[i].size() == 1) {
        leaf[i] = true;
    }
}

int sumLeaves = 0;

for (int i = 0; i < n; i++) {

    if (leaf[i]) {
        sumLeaves += value[i];
    }
}

long productRed = 1;

for (int i = 0; i < n; i++) {

    if (color[i] == 0) {
        productRed =
            (productRed * value[i]) % 1000000007;
    }
}

int evenDepthSum = 0;
int greenLeafSum = 0;

for (int i = 0; i < n; i++) {

    if (!leaf[i] && depth[i] % 2 == 0) {
        evenDepthSum += value[i];
    }

    if (leaf[i] && color[i] == 1) {
        greenLeafSum += value[i];
    }
}

int fancyResult =
    Math.abs(evenDepthSum - greenLeafSum);

System.out.println(sumLeaves);
System.out.println(productRed);
System.out.println(fancyResult);
    }
}
