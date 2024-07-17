/**
 * This class receives input from user and prints the paths taken from taxis to clients and clients to shops.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 05/04/2024
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SimulatorTwo {

   //Method to see if client can be helped
   public static boolean getValid(ArrayList<Path> taxi, ArrayList<Path> shop){
      if(taxi.get(0).cost==Graph.INFINITY || shop.get(0).cost==Graph.INFINITY){
         return false;
      }
      else{
         return true;
      }
   } 

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

            for (int x = 1; x < line.length-1; x += 2) {
                String dest = line[x];
                double weight = Double.parseDouble(line[x + 1]);
                graph.addEdge(source, dest, weight);
            }
            
        }
        //Reading shops,taxis and companies into arrays
        int numShops = keyboard.nextInt();
        keyboard.nextLine();
        int numTaxis = 0;
        ArrayList<String> shopsWithTaxis = new ArrayList<>();
        ArrayList<String> shops = new ArrayList<>();
        ArrayList<String> taxiCompanies = new ArrayList<>();
        ArrayList<String> shopCompanies = new ArrayList<>();

        String[] line2 = keyboard.nextLine().split(" ");
        for (int i = 0; i <= numShops; i+=2) {
            shops.add(line2[i]);
            String company = line2[i+1].substring(1,line2[i+1].length());
            shopCompanies.add(company);
            if(line2[i+1].contains("T")){
               shopsWithTaxis.add(line2[i]);
               numTaxis++;
               taxiCompanies.add(company);
            }
               
            

        }
        //Reading clients into an array.
        int numClients = keyboard.nextInt();
        ArrayList<String> clients = new ArrayList<>();
        for (int i = 0; i < numClients; i++) {
            clients.add(Integer.toString(keyboard.nextInt()));
        }
        keyboard.close();

        // Outputing the information.
        for(int i=0; i<numClients; i++){
           System.out.println("client "+ clients.get(i));
         
           ArrayList<Path> taxiPaths = new ArrayList<>();
           ArrayList<Path> shopPaths = new ArrayList<>();
           
           //Reading paths from taxi to client into an arrayList
           for(int x=0; x<numTaxis; x++){
            graph.dijkstra(shopsWithTaxis.get(x));
            Vertex v = new Vertex(graph.getVertex(clients.get(i)));
            taxiPaths.add(new Path(v,v.dist,shopsWithTaxis.get(x),taxiCompanies.get(x)));
           }
           
           graph.dijkstra(clients.get(i));
           
           //Reading paths from client to shop into an arrayList
           for(int z=0; z<numShops; z++){
            Vertex w = new Vertex (graph.getVertex(shops.get(z)));
            shopPaths.add(new Path(w,w.dist,clients.get(i),shopCompanies.get(z)));
           }
           
           Collections.sort(taxiPaths);
           Collections.sort(shopPaths);
           
           if(getValid(taxiPaths, shopPaths)){
           String taxiCompany ="";
           
           //Finding the path from the taxi to the client
           for(int c=0; c<taxiPaths.size(); c++){
            if(taxiPaths.get(c).cost == taxiPaths.get(0).cost){
               System.out.println("taxi "+ taxiPaths.get(c).name+" "+ taxiPaths.get(c).company );
               taxiCompany = taxiPaths.get(c).company;
               
               if (taxiPaths.get(c).dest.several == 0){
                  graph.printPath(taxiPaths.get(c).dest);
                  System.out.println();
               }
               else{
                  System.out.println("multiple solutions cost " + (int) taxiPaths.get(c).cost);
               }
            }
            else{
               
               break;
            
            }
            }
            //Finding the path from the client to the shop of correct company
            int count = 0;
            for(int d=0; d<shopPaths.size(); d++){
            if((count==0)&&(shopPaths.get(d).company.equals(taxiCompany))){
               count++;
               System.out.println("shop "+ shopPaths.get(d).dest.name+" "+shopPaths.get(d).company );
            if (shopPaths.get(d).dest.several == 0){
               graph.printPath(shopPaths.get(d).dest);
               System.out.println();
            }
            else{
               System.out.println("multiple solutions cost " + (int)shopPaths.get(d).cost);
            }
            }
            
           }
          }
          else{
            System.out.println("cannot be helped");
          }
        
        

    }

}
}



