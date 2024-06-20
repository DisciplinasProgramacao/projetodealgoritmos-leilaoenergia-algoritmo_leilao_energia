import java.util.Scanner;

public class MainProfessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o algoritmo (digite o número correspondente):");
        System.out.println("1. Backtracking");
        System.out.println("2. Divisão e Conquista");
        System.out.println("3. Programação Dinâmica");

        int algoritmoEscolhido = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha o conjunto de dados (digite o número correspondente):");
        System.out.println("1. Conjunto 1");
        System.out.println("2. Conjunto 2");

        int conjuntoEscolhido = scanner.nextInt();
        scanner.nextLine();

        Conjunto dados;
        if (conjuntoEscolhido == 1) {
            dados = ConjuntoDoProfessor.gerarPrimeiroConjunto();
        } else {
            dados = ConjuntoDoProfessor.gerarSegundoConjunto();
        }

        String algoritmoNome;
        String resultado = "";
        long startTime, endTime, tempo;
        double tempoSegundos;

        switch (algoritmoEscolhido) {
            case 1:
                algoritmoNome = "Backtracking";
                startTime = System.currentTimeMillis();
                resultado = Backtracking.solve(dados);
                endTime = System.currentTimeMillis();
                break;
            case 2:
                algoritmoNome = "Divisão e Conquista";
                startTime = System.currentTimeMillis();
                resultado = DivisaoConquista.solve(dados);
                endTime = System.currentTimeMillis();
                break;
            case 3:
                algoritmoNome = "Programação Dinâmica";
                startTime = System.currentTimeMillis();
                resultado = ProgramacaoDinamica.solve(dados);
                endTime = System.currentTimeMillis();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        tempo = endTime - startTime;
        tempoSegundos = tempo / 1000.0;

        String resultadoString = String.format("Algoritmo: %s, Conjunto: %d, Tempo: %.2fs, Resultado: %s", algoritmoNome, conjuntoEscolhido, tempoSegundos, resultado);
        System.out.println(resultadoString);
    }
}
