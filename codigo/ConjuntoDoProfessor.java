import java.util.ArrayList;
import java.util.List;

class ConjuntoDoProfessor {

    public static Conjunto gerarPrimeiroConjunto() {
        List<Lance> lances = new ArrayList<>();
        lances.add(new Lance("E1", 430, 1043));
        lances.add(new Lance("E2", 428, 1188));
        lances.add(new Lance("E3", 410, 1565));
        lances.add(new Lance("E4", 385, 1333));
        lances.add(new Lance("E5", 399, 1214));
        lances.add(new Lance("E6", 382, 1498));
        lances.add(new Lance("E7", 416, 1540));
        lances.add(new Lance("E8", 436, 1172));
        lances.add(new Lance("E9", 416, 1386));
        lances.add(new Lance("E10", 423, 1097));
        lances.add(new Lance("E11", 400, 1463));
        lances.add(new Lance("E12", 406, 1353));
        lances.add(new Lance("E13", 403, 1568));
        lances.add(new Lance("E14", 390, 1228));
        lances.add(new Lance("E15", 387, 1542));
        lances.add(new Lance("E16", 390, 1206));
        lances.add(new Lance("E17", 430, 1175));
        lances.add(new Lance("E18", 397, 1492));
        lances.add(new Lance("E19", 392, 1293));
        lances.add(new Lance("E20", 393, 1533));
        lances.add(new Lance("E21", 439, 1149));
        lances.add(new Lance("E22", 403, 1277));
        lances.add(new Lance("E23", 415, 1624));
        lances.add(new Lance("E24", 387, 1280));
        lances.add(new Lance("E25", 417, 1330));
        return new Conjunto(8000, lances);
    }

    public static Conjunto gerarSegundoConjunto() {
        List<Lance> lances = new ArrayList<>();
        lances.add(new Lance("E1", 430, 1043));
        lances.add(new Lance("E2", 428, 1188));
        lances.add(new Lance("E3", 410, 1565));
        lances.add(new Lance("E4", 385, 1333));
        lances.add(new Lance("E5", 399, 1214));
        lances.add(new Lance("E6", 382, 1498));
        lances.add(new Lance("E7", 416, 1540));
        lances.add(new Lance("E8", 436, 1172));
        lances.add(new Lance("E9", 416, 1386));
        lances.add(new Lance("E10", 423, 1097));
        lances.add(new Lance("E11", 400, 1463));
        lances.add(new Lance("E12", 406, 1353));
        lances.add(new Lance("E13", 403, 1568));
        lances.add(new Lance("E14", 390, 1228));
        lances.add(new Lance("E15", 387, 1542));
        lances.add(new Lance("E16", 390, 1206));
        lances.add(new Lance("E17", 430, 1175));
        lances.add(new Lance("E18", 397, 1492));
        lances.add(new Lance("E19", 392, 1293));
        lances.add(new Lance("E20", 393, 1533));
        lances.add(new Lance("E21", 439, 1149));
        lances.add(new Lance("E22", 403, 1277));
        lances.add(new Lance("E23", 415, 1624));
        lances.add(new Lance("E24", 387, 1280));
        lances.add(new Lance("E25", 417, 1330));
        lances.add(new Lance("E1", 313, 1496));
        lances.add(new Lance("E2", 398, 1768));
        lances.add(new Lance("E3", 240, 1210));
        lances.add(new Lance("E4", 433, 2327));
        lances.add(new Lance("E5", 301, 1263));
        lances.add(new Lance("E6", 297, 1499));
        lances.add(new Lance("E7", 232, 1209));
        lances.add(new Lance("E8", 614, 2342));
        lances.add(new Lance("E9", 558, 2983));
        lances.add(new Lance("E10", 495, 2259));
        lances.add(new Lance("E11", 310, 1381));
        lances.add(new Lance("E12", 213, 961));
        lances.add(new Lance("E13", 213, 1115));
        lances.add(new Lance("E14", 346, 1552));
        lances.add(new Lance("E15", 385, 2023));
        lances.add(new Lance("E16", 240, 1234));
        lances.add(new Lance("E17", 483, 2828));
        lances.add(new Lance("E18", 487, 2617));
        lances.add(new Lance("E19", 709, 2328));
        lances.add(new Lance("E20", 358, 1847));
        lances.add(new Lance("E21", 467, 2038));
        lances.add(new Lance("E22", 363, 2007));
        lances.add(new Lance("E23", 279, 1311));
        lances.add(new Lance("E24", 589, 3164));
        lances.add(new Lance("E25", 476, 2480));
        return new Conjunto(8000, lances);
    }

    public static void main(String[] args) {
        Conjunto conjunto1 = gerarPrimeiroConjunto();
        Conjunto conjunto2 = gerarSegundoConjunto();

        System.out.println("Conjunto 1:");
        for (Lance lance : conjunto1.lances) {
            System.out.println(lance);
        }

        System.out.println("\nConjunto 2:");
        for (Lance lance : conjunto2.lances) {
            System.out.println(lance);
        }
    }
}
