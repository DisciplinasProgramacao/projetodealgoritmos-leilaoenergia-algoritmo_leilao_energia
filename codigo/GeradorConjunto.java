import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Classes
// GeradorConjunto -> gera 10 conjuntos de tamanho N (passado como parametro), retorna uma lista de 10 Conjunto (classe abaixo)
// Lance -> contém informação do lance de cada empresa
// Conjunto -> contém a informação da energia produzida e os lances das N empresas

class GeradorConjunto {
    private static Random random = new Random(42); // Semente para garantir consistência nos testes

    public static Conjunto generateTestSet(int size) {
        List<Lance> bids = new ArrayList<>();
        int totalEnergy = 0;

        for (int j = 0; j < size; j++) {
            int energy = random.nextInt(1000) + 1; // Energia entre 1 e 1000
            int dinheiro = random.nextInt(1000) + 1;  // Valor entre 1 e 1000
            bids.add(new Lance("I" + (j + 1), energy, dinheiro));
            totalEnergy += energy;
        }

        int availableEnergy = random.nextInt(totalEnergy) + 1; // Energia disponível menor que a soma total

        return new Conjunto(availableEnergy, bids);
    }

    public static void main(String[] args) {
        int size = 10;
        int setNumber = 2;
        for (int i = 0; i < setNumber; i++) {
            Conjunto conjunto = generateTestSet(size);
            System.out.println("Gerado conjunto com X energia produzida: " + conjunto.energiaProduzida);
            for (Lance bid : conjunto.lances) {
                System.out.println(bid);
            }
            System.out.println("----");
        }
    }
}

class Lance {
    String interessada;
    int megawatts;
    int dinheiro;

    Lance(String interessada, int megawatts, int dinheiro) {
        this.interessada = interessada;
        this.megawatts = megawatts;
        this.dinheiro = dinheiro;
    }

    @Override
    public String toString() {
        return "Interessada: " + interessada + ", Megawatts: " + megawatts + ", Value: " + dinheiro;
    }
}

class Conjunto {
    int energiaProduzida;
    List<Lance> lances;

    Conjunto(int energiaProduzida, List<Lance> lances) {
        this.energiaProduzida = energiaProduzida;
        this.lances = lances;
    }
}