public class ViajeroCaminoCorto {
    private static final int N = 10; // Número de ciudades
    private static final int INF = Integer.MAX_VALUE; // Infinito

    // Matriz de distancias entre ciudades
    private static int[][] distancias = {
    	    {0, 4, INF, 3, INF, INF, INF, INF, INF, INF},
    	    {4, 0, 6, INF, 7, INF, INF, INF, INF, INF},
    	    {INF, 6, 0, 2, 4, INF, INF, INF, INF, INF},
    	    {3, INF, 2, 0, INF, INF, 1, INF, INF, INF},
    	    {INF, 7, 4, INF, 0, INF, 5, INF, INF, INF},
    	    {INF, INF, INF, INF, INF, 0, 3, 6, INF, INF},
    	    {INF, INF, INF, 1, 5, 3, 0, 3, 4, INF},
    	    {INF, INF, INF, INF, INF, 6, 3, 0, 1, 3},
    	    {INF, INF, INF, INF, INF, INF, 4, 1, 0, 4},
    	    {INF, INF, INF, INF, INF, INF, INF, 3, 4, 0}
    	};


    public static void main(String[] args) {
        int ciudadInicio = 0; // Ciudad A
        int ciudadFinal = 9; // Ciudad J

        int caminoCorto = caminoMasCorto(ciudadInicio, ciudadFinal);
        System.out.println("La distancia más corta de A a J es: " + caminoCorto);
    }

    private static int caminoMasCorto(int inicio, int fin) {
        int[] dist = new int[N];
        boolean[] visitado = new boolean[N];

        // Inicializar distancias
        for (int i = 0; i < N; i++) {
            dist[i] = INF;
        }
        dist[inicio] = 0; // Initialize the distance of the starting node to 0

        // Encontrar camino más corto
        for (int i = 0; i < N - 1; i++) {
            int u = minimoCosto(dist, visitado);
            visitado[u] = true;

            for (int v = 0; v < N; v++) {
                if (!visitado[v] && distancias[u][v] != INF && dist[u] != INF && dist[u] + distancias[u][v] < dist[v]) {
                    dist[v] = dist[u] + distancias[u][v];
                }
            }
        }

        return dist[fin];
    }



    private static int minimoCosto(int[] dist, boolean[] visitado) {
        int min = INF;
        int minIndice = -1;

        for (int v = 0; v < N; v++) {
            if (!visitado[v] && dist[v] < min) {
                min = dist[v];
                minIndice = v;
            }
        }

        return minIndice;
    }
}