
public class SimpleCalculatable implements Calculatable{
	int i;
	@Override
	public int getValue() {
		return i;
	}
	public SimpleCalculatable(int i) {
		this.i=i;
	}
	public static void main(String[] args) {
		SimpleCalculatable s = new SimpleCalculatable(1);
		System.out.println(s instanceof Calculatable);
	}
	@Override
	public void negate() {
		// TODO Auto-generated method stub
		
	}

}
