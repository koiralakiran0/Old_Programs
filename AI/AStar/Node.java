public class Node implements Comparable{
	private int row, col, total, cost, heuristic, visitable;
	private Node parent;
	
	public Node(int r, int c, int visit){
		row = r;
		col = c;
		visitable = visit;//0 is visitable, 1 is not visitable
		parent = null;
	}

	public void setCost(int cost1) {
		this.cost = cost1;
		total = cost + heuristic;
	}
	public void setHeuristic(int heuristic1) {
		this.heuristic = heuristic1;
		total = cost + heuristic;
	}
	public void setParent(Node parent1) {
		this.parent = parent1;
	}
	
	
	public int getCost() {
		return cost;
	}
	public int getCol() {
		return col;
	}
	public int getHeuristic() {
		return heuristic;
	}
	public int getRow(){
		return row;
	}

	public int getTotal(){
		return total;
	}
	
	public int getVisit(){
		return visitable;
	}

	public Node getParent() {
		return parent;
	}

	public boolean equals(Object in){
		//typecast to Node
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	public String toString(){
		return "Node: " + row + "_" + col;
	}

	@Override
	public int compareTo(Object in) {
		int val;
		Node node = (Node) in;
		if (this.getTotal() == node.getTotal())
			val = 0;
		else if (this.getTotal() > node.getTotal())
			val = 1;
		else
			val = -1;
		return val;
	}

}