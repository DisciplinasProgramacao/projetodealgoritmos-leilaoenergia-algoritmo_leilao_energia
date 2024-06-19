import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static String solve(Conjunto conjunto) {
        List<Lance> bestSolution = new ArrayList<>();
        List<Lance> currentSolution = new ArrayList<>();
        int[] maxValue = {0};

        backtrack(conjunto.lances, conjunto.energiaProduzida, 0, 0, currentSolution, bestSolution, maxValue);

        return formatResult(bestSolution, maxValue[0]);
    }

    private static void backtrack(List<Lance> lances, int energiaDisponivel, int currentIndex, int currentValue, List<Lance> currentSolution, List<Lance> bestSolution, int[] maxValue) {
        if (currentValue > maxValue[0]) {
            maxValue[0] = currentValue;
            bestSolution.clear();
            bestSolution.addAll(new ArrayList<>(currentSolution));
        }

        for (int i = currentIndex; i < lances.size(); i++) {
            Lance lance = lances.get(i);
            if (energiaDisponivel >= lance.megawatts) {
                currentSolution.add(lance);
                backtrack(lances, energiaDisponivel - lance.megawatts, i + 1, currentValue + lance.dinheiro, currentSolution, bestSolution, maxValue);
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }

    private static String formatResult(List<Lance> solution, int maxValue) {
        int totalMegawatts = solution.stream().mapToInt(l -> l.megawatts).sum();

        return String.format("[Megawatts utilizado: %d, Dinheiro total: %d]", totalMegawatts, maxValue);

    }

    // Testando o Algoritmo
    public static void main(String[] args) {
        Conjunto conjunto = GeradorConjunto.generateTestSet(10);
        conjunto = GeradorConjunto.generateTestSet(10);
        String resultado = solve(conjunto);
        System.out.println(resultado);
    }
}
