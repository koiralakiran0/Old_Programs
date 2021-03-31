import java.util.*;

public class aStar {
    //GLOBAL OPENLIST AND CLOSEDLIST
    static PriorityQueue<Node> openList = new PriorityQueue<Node>();
    static HashSet<Node> closedList = new HashSet<Node>();
    static int SIZE = 15;
    
    public static void main(String[] args) {
        //clear the openlist and endlist
        openList.clear();
        closedList.clear();
        //Store the node objects
        Node[][] grid = new Node[SIZE][SIZE];
        
        //populate grid
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                Node newNode;
                if (Math.random() < .10)//Unpathable ten percent of the time
                    newNode = new Node(i, j, 1);
               else
                   newNode = new Node(i, j, 0);
                grid[i][j] = newNode;
            }
        }
        //Show the grid before the Input
        print(grid);
        
        //TAKE INPUT IN
        Scanner input = new Scanner(System.in);
        System.out.println("Enter X start");
        int startX = 0;
        startX =input.nextInt();
        System.out.println("Enter Y start");
        int startY = input.nextInt();
        
        System.out.println("Enter X finish");
        int finishX = input.nextInt();
        System.out.println("Enter Y finish");
        int finishY = input.nextInt();
        
        //check if input is right
        if (outOfBounds(startX, startY) == 1 || outOfBounds(finishX, finishY) == 1 ||
                grid[startX][startY].getVisit() == 1 || grid[finishX][finishY].getVisit() == 1){
            System.out.println("Invalid Input! RESTART");
            //restart();   // causes problem when running
            System.exit(0);
        }
        
        
        //Setting the Heuristic
        //Setting all cost to 1000
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                int h = (Math.abs(finishX-i) + Math.abs(finishY-j)) * 10;
                grid[i][j].setHeuristic(h);
                grid[i][j].setCost(1000);
            }
        }
        
        grid[startX][startY].setCost(0);//startNode gets 0 cost at beginning
        openList.add(grid[startX][startY]);//add startNode to openlist
        
        int restart = 1;
        //MAIN LOOP, setting cost etc
        while (restart == 1){
            //If the openlist is empty, we will know we cannot move anywhere
            if (openList.isEmpty()){
                System.out.println("Empty OpenList. NODE unpathable");
                break;
            }
            
            //remove from openlist to work with
            Node current = openList.remove();
            
            //Checking if the closedList already has the current node, skips the loop if it does
            if (closedList.contains(current)){
                continue;
            }
            //if the current node is the goal node
            if (current.getRow() == finishX && current.getCol() == finishY){
                System.out.println("FOUND FINAL PATH! PRINTING");
                int[][] path = new int[SIZE][SIZE];
                int pRepeat = 1;
                while (pRepeat == 1){
                    path[current.getRow()][current.getCol()] = 1;
                    current = current.getParent();
                    if (current.getRow() == startX && current.getCol() == startY){
                        pRepeat = 0;
                    }
                }
                path[startX][startY] = 1;
                printFinalPath(path, grid);
                break;
            }
            //Assigns a method to find Neighbours
            findNeighbours(current, grid);
            closedList.add(current);//finished working with the current one
        }
        input.close();
    }

    private static void findNeighbours(Node current, Node[][] grid) {
        int x = current.getRow();//ROW of current node to check the neighbors
        int y = current.getCol();//COL to check neighbors
        
        //ADD the neighbors on all 8 sides
        addNeighbours(x+1, y+1, current, grid, 14);
        addNeighbours(x-1, y-1, current, grid, 14);
        addNeighbours(x+1, y-1, current, grid, 14);
        addNeighbours(x-1, y+1, current, grid,  14);
        
        addNeighbours(x, y-1, current, grid, 10);
        addNeighbours(x, y+1, current, grid, 10);
        addNeighbours(x-1, y, current, grid, 10);
        addNeighbours(x+1, y, current, grid, 10);
    }

    private static void addNeighbours(int i, int j, Node current, Node[][] grid, int addCost) {
        //BEFORE ADDING
        //  1. check if x and y are out of bounds
        //  2. Node at x and y are in the closed List
        //  3. Node is unpathable
        //  4. Cost to get to that node is less than the cost it already has
        int cost = current.getCost() + addCost;
        if (outOfBounds(i, j) == 0 && !closedList.contains(grid[i][j]) && grid[i][j].getVisit() == 0 ){//&& grid[i][j].getCost() > cost){
            openList.add(grid[i][j]);
            grid[i][j].setParent(current);
            //System.out.println("NODE " + i + " " + j + " ADDED");
        }
    }
    //CAUSES PROBLEM
    private static void restart() {
        String[] args = new String[0];
        main(args);//RESTARTS THE MAIN method
    }

    private static int outOfBounds(int x, int y) {
        if (x>14 || y > 14|| x < 0 || y < 0){
            return 1;//1 IS OUT OF BOUNDS
        }else
            return 0;// 0 is NOT out of bounds
    }
    
    /**
     * Prints all the Nodes
     * (**) for Unpathable
     * (  ) for pathable
     */
    private static void print(Node[][] nodes) {
        int g = 0;
        for (int row = 0; row < nodes.length; row++){
            for (int col = 0; col < nodes[row].length; col++){
                if (nodes[row][col].getVisit() == 0)
                    System.out.print("(  )");
                else
                    System.out.print("(**)");
                //System.out.print( nodes[row][col].getF() + "  |  ");
                
            }
            g+=1;
            System.out.println(" " + g);
        }
    }
    
    /**
     * Prints the final path along with all the nodes
     * (**) for Unpathable
     * (  ) for pathable
     * (^^) for the ACTUAL PATH
     */
    private static void printFinalPath(int[][] path, Node[][] nodes) {
        int g = 0;
        for (int row = 0; row < nodes.length; row++){
            for (int col = 0; col < nodes[row].length; col++){
                if (nodes[row][col].getVisit() == 1)
                    System.out.print("(**)");
               else if (path[row][col] == 1)
                    System.out.print("(^^)");
                else
                    System.out.print("(  )");
                //System.out.print( nodes[row][col].getF() + "  |  ");
                
            }
            g+=1;
            System.out.println(" " + g);
        }
    }
}

