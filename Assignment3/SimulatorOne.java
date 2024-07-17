import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import Graphs.Graph;
import javafx.scene.shape.Path;

public class SimulatorOne {

    public static void main(String[] args) {
        Graph graph = new Graph();
        final Scanner keyboard = new Scanner(System.in);

        // Reading the nodes and edges.
        int numOfNodes = keyboard.nextInt();
        keyboard.nextLine();
        // Reading all the information from the file.
        for (int i = 0; i < numOfNodes; i++) {
            String[] line = keyboard.nextLine().split(" ");
            String source = line[0];

            for (int x = 1; x < line.length; x += 2) {
                String dest = line[x];
                int weight = Integer.parseInt(line[x + 1]);
                graph.addEdge(source, dest, weight);
            }
            
        }
        int numShops = keyboard.nextInt();
        ArrayList<String> shops = new ArrayList<>();
        for (int i = 0; i < numShops; i++) {
            shops.add(Integer.toString(keyboard.nextInt()));

        }
        int numClients = keyboard.nextInt();
        ArrayList<String> clients = new ArrayList<>();
        for (int i = 0; i < numClients; i++) {
            clients.add(Integer.toString(keyboard.nextInt()));
        }
        keyboard.close();

        // Outputing the information.
        for (int i = 0; i < numClients; i++) {
            System.out.println("client " + clients.get(i));
            // finding closest taxi

            ArrayList<String> taxiPaths = graph.taxiList(shops, clients.get(i));
            for(int x=0; x<taxiPaths.size();x++){
                System.out.println(taxiPaths.get(x));
            }  

            ArrayList<String> shopPaths = graph.shopList(shops, clients.get(i));

            for(int z=0; z<shopPaths.size(); z++){
                System.out.println(shopPaths.get(z));
            }
        }

    }

}
