import java.util.*;

public class DivisaoConquista {

    // Função principal para encontrar o valor máximo obtido e calcular megawatts gastos
    public static String solve(Conjunto conjunto) {
        int[] resultado = new int[2];
        resultado[0] = maxValueHelper(conjunto.lances, conjunto.energiaProduzida, 0); // Valor máximo obtido
        resultado[1] = conjunto.energiaProduzida - energiaRestante(conjunto.lances); // Megawatts gastos
        return String.format("[Megawatts utilizado: %d, Dinheiro total: %d]", resultado[1], resultado[0]);
    }

    // Função auxiliar para calcular o valor máximo e atualizar a lista de lances
    private static int maxValueHelper(List<Lance> lances, int energiaDisponivel, int megawattsGastos) {
        // Caso base: se não há mais lances ou não há mais energia para vender
        if (lances.size() == 0 || energiaDisponivel == 0) {
            return 0;
        }

        Lance lanceAtual = lances.get(lances.size() - 1);

        // Se o lance atual consome mais energia do que a energia total disponível,
        // não podemos incluí-lo na solução
        if (lanceAtual.megawatts > energiaDisponivel) {
            lances.remove(lanceAtual);
            return maxValueHelper(lances, energiaDisponivel, megawattsGastos);
        }

        // Caso contrário, calcular o máximo entre incluir ou não incluir o lance atual
        lances.remove(lanceAtual);
        int incluirLance = lanceAtual.dinheiro + maxValueHelper(lances, energiaDisponivel - lanceAtual.megawatts, megawattsGastos + lanceAtual.megawatts);
        int naoIncluirLance = maxValueHelper(lances, energiaDisponivel, megawattsGastos);

        return Math.max(incluirLance, naoIncluirLance);
    }

    // Função auxiliar para calcular a energia restante após a seleção de lances
    private static int energiaRestante(List<Lance> lances) {
        int energiaGasta = 0;
        for (Lance lance : lances) {
            energiaGasta += lance.megawatts;
        }
        return energiaGasta;
    }

}