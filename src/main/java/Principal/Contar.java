package Principal;

import java.nio.file.*;
import java.util.*;

public class Contar {

    private HashMap<String, Integer> votos;
    private int votosNulos;

    public Contar() {
        votos = new HashMap<>();
        votosNulos = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get("conteo.csv"));
            // Skip the header line
            lines.remove(0);
            for (String line : lines) {
                String[] parts = line.split(",");
                String id = parts[0];
                int voto = Integer.parseInt(parts[1]);
                votos.put(id, votos.getOrDefault(id, 0) + voto);
            }
            // Contar votos nulos
            List<String> linesNulos = Files.readAllLines(Paths.get("conteonulos.csv"));
            votosNulos = linesNulos.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> getVotos() {
        return votos;
    }


    public int getVotosNulos() {
        return votosNulos;
    }

}
