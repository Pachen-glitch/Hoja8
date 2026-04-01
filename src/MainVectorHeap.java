import java.io.*;

public class MainVectorHeap {

    public static void main(String[] args) throws Exception {
        VectorHeap<Paciente> pq = new VectorHeap<>();

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
            System.out.println(pq.remove());
        }
    }
}