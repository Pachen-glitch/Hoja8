import java.io.*;
import java.util.*;

public class MainJavaPQ {

    public static void main(String[] args) throws Exception {
        java.util.PriorityQueue<Paciente> pq = new java.util.PriorityQueue<>();

        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0].trim();
            String sintoma = parts[1].trim();
            char prioridad = parts[2].trim().charAt(0);

            pq.add(new Paciente(nombre, sintoma, prioridad));
        }

        br.close();

        System.out.println("Orden de atención:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}