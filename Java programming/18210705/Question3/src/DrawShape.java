
public class DrawShape {
	public static enum type {
		TRIANGLE,PLUS;
	}
	public static String draw(int width,int height,type t,char a,char b,boolean p) {
		String str="";
		String strp1="";
		String strp2="";
		//print triangle
		if(t==type.TRIANGLE) {   
			if(width!=height) {
				throw new IllegalArgumentException("Invalid input");   //check 
			}
			else {
				if(p==true) {
					for(int i=0;i<height;i++) {
						for(int j=0;j<=i;j++) {
							if(i%2==0)
								str=str+a;
							if(i%2==1)
								str=str+b;
						}
						str=str+'\n';
					}
					return str;
				}else {
					for(int i=0;i<height;i++) {
						for(int j=0;j<height-i;j++) {
							if(i%2==0)
								str=str+a;
							if(i%2==1)
								str=str+b;
						}
						str=str+'\n';
					}
					return str;
				}
			}
		}
		//print plus 
		else if(t==type.PLUS) {
			if(width!=height) {
				throw new IllegalArgumentException("Invalid input");   //check
			}
			else {
				if(p==true) {
					for(int j=0;j<width/2;j++)
						strp1=strp1+" ";
					strp1=strp1+b;
					
					for(int j=0;j<width/2;j++)
						strp2=strp2+a;
					strp2=strp2+"+";
					for(int j=0;j<width/2;j++)
						strp2=strp2+a;
					
					for(int i=0;i<height/2;i++)
						str=str+strp1+"\n";
					str=str+strp2;
					str=str+'\n';
					for(int i=0;i<height/2;i++)
						str=str+strp1+"\n";
					return str;
				}
				else {
					for(int j=0;j<width/2;j++)
						strp1=strp1+" ";
					strp1=strp1+a;
					
					for(int j=0;j<width/2;j++)
						strp2=strp2+b;
					strp2=strp2+"+";
					for(int j=0;j<width/2;j++)
						strp2=strp2+b;
					
					for(int i=0;i<height/2;i++)
						str=str+strp1+"\n";
					str=str+strp2;
					str=str+'\n';
					for(int i=0;i<height/2;i++)
						str=str+strp1+"\n";
					return str;
				}
				
			}
		}
		return str;
	}
	public static void main(String[] args) {
		String answer1 = DrawShape.draw(4, 4, DrawShape.type.TRIANGLE, 'x', 'o', true);
		System.out.println(answer1);
		String answer2 = DrawShape.draw(10, 10, DrawShape.type.TRIANGLE, 'x', 'o', false);
		System.out.println(answer2);
		String answer = DrawShape.draw(5, 5, DrawShape.type.PLUS, 'v', 'y', true);
		answer = DrawShape.draw(7, 7, DrawShape.type.PLUS, 'e', 't', false);
		System.out.println(answer);
		String answer3 = DrawShape.draw(5, 5, DrawShape.type.PLUS, 'v', 'y', true);
		System.out.println(answer3);
	}

}
