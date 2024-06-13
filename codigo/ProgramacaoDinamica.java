import java.util.ArrayList;
import java.util.List;

public class ProgramacaoDinamica {

    public static String solve(Conjunto conjunto) {
        int n = conjunto.lances.size();
        int W = conjunto.energiaProduzida;

        int[][] dp = new int[n + 1][W + 1];
        boolean[][] keep = new boolean[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            Lance lance = conjunto.lances.get(i - 1);
            for (int w = 0; w <= W; w++) {
                if (lance.megawatts <= w) {
                    int includeLance = lance.dinheiro + dp[i - 1][w - lance.megawatts];
                    if (includeLance > dp[i - 1][w]) {
                        dp[i][w] = includeLance;
                        keep[i][w] = true;
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int maxValue = dp[n][W];
        List<Lance> solution = new ArrayList<>();
        for (int i = n, w = W; i > 0; i--) {
            if (keep[i][w]) {
                Lance lance = conjunto.lances.get(i - 1);
                solution.add(lance);
                w -= lance.megawatts;
            }
        }

        return formatResult(solution, maxValue);
    }

    private static String formatResult(List<Lance> solution, int maxValue) {
        int totalMegawatts = solution.stream().mapToInt(l -> l.megawatts).sum();
        return String.format("[Megawatts utilizado: %d, Dinheiro total: %d]", totalMegawatts, maxValue);
    }

}
