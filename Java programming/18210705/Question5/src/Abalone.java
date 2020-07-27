
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Abalone {
	
	private static final int MALE = 0;
	private static final int FEMALE = 1;
	private static final int INFANT = 2;
	int sex;
	double length;
	double diameter;
	double weight;
	int age;
	
	public Abalone(int male2, double d, double e, double f, int i) {
		sex=male2;
		length=d;
		diameter=e;
		weight=f;
		age=i;
	}
	public String toString() {
		String str="";
		if(sex==0) {
			str="Abalone(M), length="+length+", diameter="+diameter+", weight="+weight+", age="+age;
			return str;
		}
		else if(sex==1) {
			str="Abalone(F), length="+length+", diameter="+diameter+", weight="+weight+", age="+age;
			return str;
		}
		else if(sex==2) {
			str="Abalone(I), length="+length+", diameter="+diameter+", weight="+weight+", age="+age;
			return str;
		}
		
		return str;
	}
	public boolean equals(Object o) {
		if (o instanceof Abalone) {
			Abalone a=(Abalone)o;
		return sex==a.sex&& length==a.length && diameter==a.diameter && weight==a.weight && age==a.age;
		} else {
		return false;
		}
	}
	
	private static ArrayList<Abalone> read(File f) throws IOException{
		Scanner sc = new Scanner(f);
        Scanner sc1;
        ArrayList<Abalone> Abalones = new ArrayList<Abalone>();
        int a;
        double b;
        double c;
        double d;
        int e;
        while(sc.hasNextLine()) {
            sc1 = new Scanner(sc.nextLine());
            System.out.println(sc1);
            sc1.useDelimiter(",");
            a = Integer.parseInt(sc1.next());
            b=Double.parseDouble(sc1.next());
            c=Double.parseDouble(sc1.next());
            d=Double.parseDouble(sc1.next());
            e = Integer.parseInt(sc1.next());
            
            Abalones.add(new Abalone(a,b,c,d,e));
        }
		
        return Abalones;
	}
	
	
	public static void main(String[] args) {
		Abalone a1 = new Abalone(Abalone.MALE, .35, .53, .64, 10);
		Abalone a2 = new Abalone(Abalone.FEMALE, .45, .43, .51, 5);
		Abalone a3 = new Abalone(Abalone.INFANT, .15, .16, .05, 1);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a1));
		
        File f = new File("testData.csv");
		try {
			ArrayList<Abalone> al = Abalone.read(f);
			System.out.println(al.get(0));
		} catch (Exception ex) {
			
		}
	}
	
}
