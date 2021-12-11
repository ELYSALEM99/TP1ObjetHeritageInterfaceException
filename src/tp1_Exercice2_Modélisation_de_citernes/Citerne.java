package tp1_Exercice2_Modélisation_de_citernes;

import java.time.LocalDate;

import tp1_Exercice1_Interfaces.EstComparable;


public class Citerne implements EstComparable,Cloneable {
    private int Id;
    private Liquide liquide;
    private int capacite;
    private double capaciteTP;
    static final int CAPACITEMAX=20000;
    private LocalDate date;
	private double Qnt_liquide_stocke;
    static int nbr_citerne_construites=0;
    
    public Citerne(int Id,int capacite,int annee ,int mois,int jour,Liquide liquide,double Qnt_liquide_stocke) throws IllegalArgumentException{
    	if(capacite<=0)
    		throw new IllegalArgumentException();
    	this.Id=Id;
    	this.capacite=capacite;
    	this.date=LocalDate.of(annee,mois,jour); 
    	this.liquide=liquide;
    	this.Qnt_liquide_stocke=Qnt_liquide_stocke;
    	nbr_citerne_construites++;
    }
    
    public Citerne(double capaciteTP,Liquide liquide,double Qnt_liquide_stocke) {
    	this.capaciteTP=capaciteTP; 
    	this.liquide=liquide;
    	this.Qnt_liquide_stocke=Qnt_liquide_stocke;
    }
    
    public Citerne plusAncienne(Citerne ci) {
    	Citerne c=ci;
    	if ((this.date).isBefore(ci.date))
    		c=this;
    	return c;
    }
    
    public double getCapaciteTP() {
    	return capaciteTP;
    }
    
    public void setCapaciteTp(double capaciteTP) {
    	this.capaciteTP=capaciteTP;
    }
    public void setTypeLiquide(Liquide liquide) {
    	this.nettoyage();
    	this.liquide=liquide;
    }
    public void nettoyage() {
    	System.out.println("Opération de nettoyage de la citerne");
    }
    public int getCapacite() {
    	return capacite;
    }
    
    public double getQntLiStoke(){
    	return Qnt_liquide_stocke;
    }
    
    public void setQntLiStoke(double a) {
    	this.Qnt_liquide_stocke= this.Qnt_liquide_stocke + a;
    }
    
    public Liquide gettypeLiquide() {
    	return liquide;
    }
    
    public LocalDate dateMiseService() {
    	return date;
    }
    
    public void ajouterLiquideTp(double Qntliquide) {
    	Qnt_liquide_stocke=Qnt_liquide_stocke+Qntliquide;
    }
    
    public void enleverLiquideTp(double QntVid) {
    	Qnt_liquide_stocke=QntVid;
    }
    
    public void ajouterLiquide(double Qntliquide) throws Depasser  {
    	if (Qntliquide>0 && Qntliquide<1)
    		Qnt_liquide_stocke = Qnt_liquide_stocke + Qntliquide*Qnt_liquide_stocke;
    	else
    		Qnt_liquide_stocke = Qnt_liquide_stocke + Qntliquide;
    	if(Qnt_liquide_stocke>=capacite) 
		{
			Qnt_liquide_stocke=capacite;
			throw new Depasser();
   		}	
    }
    
    public void enleverLiquide(double Qntliquide) throws Manquer {
    	if (Qntliquide>0 && Qntliquide<1)
    		Qnt_liquide_stocke = Qnt_liquide_stocke - Qntliquide*Qnt_liquide_stocke;
    	else
    		Qnt_liquide_stocke = Qnt_liquide_stocke - Qntliquide;
    	if(Qnt_liquide_stocke<=0) 
		{
			Qnt_liquide_stocke=0;
			throw new Manquer();
   		}	
    	
    }
    
    public boolean equals(Object o) {
    	boolean result=false;
    	if((o!=null) && (o instanceof Citerne))
    	{
    		Citerne c;
    		c=(Citerne)o;
    		if((c.capacite==this.capacite) && (c.date).isEqual(this.date) && (c.liquide==this.liquide) && (c.Qnt_liquide_stocke==this.Qnt_liquide_stocke))
    			result=true;
    	}
    	return result;
    }
    
   	public String toString() {
   		return "Citerne n°" + Id + ", " + liquide + ", capacite : " + capacite + "m3, mise en service : " + date
   				+ ", volume occupé : " + Qnt_liquide_stocke + "m3";
   	}
 
   	public int compareA(Object o) throws RuntimeException {
    	int result;
    	if(o==null)
    	{
    		throw new NullPointerException();
    	}
    	if((o instanceof Citerne)==false)
    	{
    		throw new ClassCastException();
    	}
    	Citerne ci;
    	ci=(Citerne)o;
    	if(this.Qnt_liquide_stocke>ci.Qnt_liquide_stocke) 
    		result=1;
    	else if(this.Qnt_liquide_stocke==ci.Qnt_liquide_stocke) 
    	{
    		if(this.capacite>ci.capacite) 
        		result=1;
    		else if(this.capacite<ci.capacite)
    			result=-1;
    		else
    			result=0;
    	}
    	else
    		result=-1;
    	return result;
    }     
   	
   	public Object clone() {
   		try {
   			Citerne C;
   			C=(Citerne)super.clone();
   			return C;
   		}catch(CloneNotSupportedException e)
   		{
   			throw new InternalError();
   		}
   	}
}

enum Liquide {eau,vin,huile}

class Depasser extends Exception{}
class Manquer extends Exception{}