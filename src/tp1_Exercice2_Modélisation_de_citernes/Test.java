package tp1_Exercice2_Modélisation_de_citernes;


public class Test {

	public static void main(String[] args) {
		try {
		Citerne c1=new Citerne(1,13,2019,10,22,Liquide.vin,9.5);
		Citerne c2=new Citerne(2,13,2018,10,22,Liquide.vin,10);
		System.out.println(c2.plusAncienne(c1));
		System.out.println(c1);
		c1.ajouterLiquide(0.1);
		System.out.println(c1);
		c1.enleverLiquide(5);
		System.out.println(c1);
		System.out.println(c2.equals(c1));
		System.out.println(c2.compareA(c1));
		Citerne CTP1= new Citerne(5,Liquide.eau,0);
		CiterneSecurisee cs1=new CiterneSecurisee(3,14,2019,10,22,Liquide.eau,10,CTP1);
		Citerne CTP2= new Citerne(7,Liquide.eau,4);
		CiterneSecurisee cs2=new CiterneSecurisee(4,21,2018,10,22,Liquide.eau,14,CTP2);
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs1.compareA(cs1));
		System.out.println(cs1.plusAncienne(cs2));
		System.out.println(cs1);
		System.out.println(cs2);
		cs1.ajouterLiquide(7);
		System.out.println(cs1);
		CiterneSecurisee cs3=(CiterneSecurisee)cs1.clone();
		System.out.println(cs3);
	}catch(IllegalArgumentException e)
		{
		   System.out.println("Attention la capacité ne doit pas pouvoir être négative ou nulle");
		}
	 catch(Depasser e)
		{
		   System.out.println("Attention la quantité de liquide est en dépassement de la capacité");
		}
	 catch(Manquer e)
		{
		   System.out.println("Attention  la quantité de liquide est manquante pour satisfaire à la demande");
		}
		catch(NullPointerException e)
		{
		   System.out.println("Attention l’objet passé en paramètre est Null");
		}
	 catch(ClassCastException e)
		{
		   System.out.println("Attention l’objet passé en paramètre est d’une classe ne permettant pas d’effectuer la comparaison avec une instance de Citerne");
		}

	}

}


