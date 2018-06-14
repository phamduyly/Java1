import javax.swing.JOptionPane;

public class PizzaMenu {

	private static int maxNum;
	private Pizza[] pizzaArray;
	private Pizza pizza;
	private int i;
	private int curP;

	public static void main(String[] args) {
		int x = Integer.parseInt(JOptionPane.showInputDialog("input no of piza"));
		//Scanner sc = new Scanner(System.in);
		PizzaMenu testObj = new PizzaMenu(x);

	}

	public PizzaMenu(int x) {
		maxNum = x;
		this.pizzaArray = new Pizza[maxNum];

		JOptionPane.showMessageDialog(null,"Maximum no piz this: " + maxNum);

		String t = JOptionPane.showInputDialog("add or find");
		//Emty to escape the while loop
		while (!t.isEmpty()) {
			if (t.contains("add")) {
				this.addPizza();
				//to escape out oof infinite loop
				t = JOptionPane.showInputDialog("what next?");
			} else if ( t.contains("find")) {
				String n = JOptionPane.showInputDialog("search name");
				findPizza(n);
				t = JOptionPane.showInputDialog("What next?");

			} else if (t.contains("show")){

				for (int i = 0; i < maxNum; i++){
					JOptionPane.showMessageDialog(null,pizzaArray[i].getName());

				}
				JOptionPane.showInputDialog("what next?");


			} else {
				t = JOptionPane.showInputDialog("what next?");
			}
		}
	}

	public Pizza getPizza() {
		return this.pizza;
	}

	public void addPizza() {

		String d = JOptionPane.showInputDialog("name");
		String y = JOptionPane.showInputDialog("price");

		if (i < pizzaArray.length) {
			this.pizzaArray[i] = new Pizza(d,y);
		} else {
			JOptionPane.showMessageDialog(null,"max reached");
		}
		i++;
		curP++;
	}

	public void findPizza(String n) {
		String[] rs = new String [maxNum];


		for (int i = 0; i < curP; i++){
			rs[i] = pizzaArray[i].getName();
		}

		boolean solutions = false;


		for (int i = 0; i < maxNum; i++){
			if (n.contains(rs[i])) {
				JOptionPane.showMessageDialog(null,"found " + n);
			} else {
				JOptionPane.showMessageDialog(null,"not found");
			}
		}

	}

}
