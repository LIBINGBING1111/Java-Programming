
public class StringCalculatable implements Calculatable{
	int i;
	String[] str2;
	String a="";
	public StringCalculatable(String str) {
		if(str.charAt(0)!='-') {
			str2=str.split("\\s+");
			for(i=0;i<str2.length;i++) {
				if(str2[i]=="zero")
					a=a+"0";
				if(str2[i]=="one")
					a=a+"1";
				if(str2[i]=="two")
					a=a+"2";
				if(str2[i]=="three")
					a=a+"3";
				if(str2[i]=="four")
					a=a+"4";
				if(str2[i]=="five")
					a=a+"5";
				if(str2[i]=="six")
					a=a+"6";
				if(str2[i]=="seven")
					a=a+"7";
				if(str2[i]=="eight")
					a=a+"8";
				if(str2[i]=="nine")
					a=a+"9";
			}
			
		}
		else if(str.charAt(0)=='-') {
			str=str.trim();
			str2=str.split("\\s+");
			for(i=0;i<str2.length;i++) {
				if(str2[i]=="zero")
					a=a+"0";
				if(str2[i]=="one")
					a=a+"1";
				if(str2[i]=="two")
					a=a+"2";
				if(str2[i]=="three")
					a=a+"3";
				if(str2[i]=="four")
					a=a+"4";
				if(str2[i]=="five")
					a=a+"5";
				if(str2[i]=="six")
					a=a+"6";
				if(str2[i]=="seven")
					a=a+"7";
				if(str2[i]=="eight")
					a=a+"8";
				if(str2[i]=="nine")
					a=a+"9";
			}
			
		}
	}
	@Override
	public int getValue() {
		return i;
	}
	public static void main(String[] args) {
		Calculatable c1 = new StringCalculatable("-one two three four five");
		System.out.println(c1.getValue());
		
		Calculatable c2 = new StringCalculatable("123");
		c2.negate();
		System.out.println(c2.getValue());
	}
	@Override
	public void negate() {
		
		
	}



}
