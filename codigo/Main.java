import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int tamanhoConjunto = 10;

        // * Importante * Trocar nome do arquivo a depender do algoritmo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("codigo/resultados/backtracking.txt"))) { // NOME ARQUIVO

            while (true) {
                List<Long> listaTempo = new ArrayList<>();
                List<String> resultados = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    Conjunto dados = GeradorConjunto.generateTestSet(tamanhoConjunto);
                    
                    // TODO fazer logica de ordenar valores (crescente)

                    long startTime = System.currentTimeMillis();

                    String resultado = Backtracking.solve(dados); // ALGORITMO

                    long endTime = System.currentTimeMillis();

                    long tempo = endTime - startTime;

                    listaTempo.add(tempo);
                    resultados.add(resultado);
                }

                long mediaTempo = listaTempo.stream().mapToLong(Long::longValue).sum() / tamanhoConjunto;
                double mediaTempoSegundos = mediaTempo / 1000.0;

                String resultadoString = resultados.stream().collect(Collectors.joining(", ", "[", "]"));
                writer.write(tamanhoConjunto + ", " + mediaTempoSegundos + "s, " + resultadoString + "\n");

                if (mediaTempoSegundos > 30) { // 30 segundos paramos a execução
                    break;
                }

                System.out.println(tamanhoConjunto);
                System.out.println(mediaTempoSegundos);
                System.out.println();

                tamanhoConjunto += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
