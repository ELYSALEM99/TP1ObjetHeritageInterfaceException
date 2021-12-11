package tp1_Exercice1_Interfaces;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= new int [] {1,2,3,4};
		int [] b= new int [] {-1,2,-3,4,5};
		int [] c= null;
		MonTableau m1= new MonTableau(a);
		MonTableau m2= new MonTableau(b);
		MonTableau m3= new MonTableau(c);
		System.out.println(m1.compareA(m2));
		System.out.println(m1.compareA(m3));
		System.out.println(m1.compareA(a));
	}
}
