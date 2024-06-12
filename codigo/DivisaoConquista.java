import java.util.ArrayList;
import java.util.List;

public class DivisaoConquista {

    public static String solve(Conjunto conjunto) {
        List<Lance> bestSolution = new ArrayList<>();
        List<Lance> currentSolution = new ArrayList<>();
        int[] maxValue = {0};

        List<Lance> lancesOrdenados = conjunto.lances;
        lancesOrdenados.sort((a, b) -> Integer.compare(b.dinheiro, a.dinheiro)); // Ordena os lances por valor (decrescente)

        divideConquista(lancesOrdenados, conjunto.energiaProduzida, 0, 0, currentSolution, bestSolution, maxValue);

        return formatResult(bestSolution, maxValue[0]);
    }

    private static void divideConquista(List<Lance> lances, int energiaDisponivel, int currentIndex, int currentValue, List<Lance> currentSolution, List<Lance> bestSolution, int[] maxValue) {
        if (currentIndex >= lances.size() || energiaDisponivel <= 0) {
            if (currentValue > maxValue[0]) {
                maxValue[0] = currentValue;
                bestSolution.clear();
                bestSolution.addAll(new ArrayList<>(currentSolution));
            }
            return;
        }

        Lance lance = lances.get(currentIndex);

        if (energiaDisponivel >= lance.megawatts) {
            currentSolution.add(lance);
            divideConquista(lances, energiaDisponivel - lance.megawatts, currentIndex + 1, currentValue + lance.dinheiro, currentSolution, bestSolution, maxValue);
            currentSolution.remove(currentSolution.size() - 1);
        }

        divideConquista(lances, energiaDisponivel, currentIndex + 1, currentValue, currentSolution, bestSolution, maxValue);
    }

    private static String formatResult(List<Lance> solution, int maxValue) {
        int totalMegawatts = solution.stream().mapToInt(l -> l.megawatts).sum();
        return String.format("[Megawatts utilizado: %d, Dinheiro total: %d]", totalMegawatts, maxValue);
    }
}
