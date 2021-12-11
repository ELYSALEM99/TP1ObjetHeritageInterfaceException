package tp1_Exercice2_Modélisation_de_citernes;


public class CiterneSecurisee extends Citerne   {
	private Citerne TropPlein;
	public CiterneSecurisee(int Id,int capacite,int annee ,int mois,int jour,Liquide liquide,double Qnt_liquide_stocke,Citerne TropPlein) {
		super(Id,capacite,annee,mois,jour,liquide,Qnt_liquide_stocke);
		this.setTropPlein(TropPlein);
		this.TropPlein=TropPlein;
	}
	
	public void setTropPlein(Citerne TropPlein) {
		if((TropPlein.getCapaciteTP()==0) || (TropPlein.gettypeLiquide()!=this.gettypeLiquide()) || TropPlein.getQntLiStoke()!=0)
		{
			TropPlein.setCapaciteTp(0.1*this.getCapacite());
			TropPlein.setTypeLiquide(this.gettypeLiquide());
			TropPlein.setQntLiStoke(-TropPlein.getQntLiStoke());
		}
	}
	
	public void dechargerCuvePrincipal(double d) {
		TropPlein.ajouterLiquideTp(d);
		if(TropPlein.getQntLiStoke()>=0.5*TropPlein.getCapaciteTP())
		{
			System.out.println("se déchargeant dans la cuve de trop plein. Attention! la cuve de trop plein est à moitié pleine ");
			System.out.println(this);
			double QntVid=0.49*TropPlein.getCapaciteTP();
			System.out.println("Opération  de vidanges");
			TropPlein.enleverLiquideTp(QntVid);
		}	
	}
	
	public void operationVidanges(double QntVid) {
		TropPlein.enleverLiquideTp(QntVid);
	}
	
	public void ajouterLiquide(double Qntliquide) {
		this.setQntLiStoke(Qntliquide);
		double d=(double)this.getCapacite()-this.getQntLiStoke();
		if(d<0)
		{
			System.out.println("se déchargeant dans la cuve de trop plein");
			this.setQntLiStoke(d);
			this.dechargerCuvePrincipal(-d);
		}
	}
	
	public void enleverLiquide(double Qntliquide) {
		this.setQntLiStoke(-Qntliquide);
	}
	
	public int compareA(Object o) {
		int result;
    	if(o==null)
    	{
    		throw new NullPointerException();
    	}
    	if((o instanceof Citerne)==false)
    	{
    		throw new ClassCastException();
    	}
    	CiterneSecurisee cs;
    	cs=(CiterneSecurisee)o;
    	if(this.getQntLiStoke()+this.TropPlein.getQntLiStoke()>cs.getQntLiStoke()+cs.TropPlein.getQntLiStoke()) 
    		result=1;
    	else if(this.getQntLiStoke()+this.TropPlein.getQntLiStoke()==cs.getQntLiStoke()+cs.TropPlein.getQntLiStoke()) 
    	{
    		if((double)this.getCapacite()+this.TropPlein.getCapaciteTP()>(double)cs.getCapacite()+cs.TropPlein.getCapaciteTP()) 
        		result=1;
    		else if((double)this.getCapacite()+this.TropPlein.getCapaciteTP()<(double)cs.getCapacite()+cs.TropPlein.getCapaciteTP())
    			result=-1;
    		else
    			result=0;
    	}
    	else
    		result=-1;
    	return result;
    }     
		
	
	public String toString() {
		return super.toString() + " *** la cuve de trop plein capacité: "+TropPlein.getCapaciteTP()+"m3, volume occupé: "+TropPlein.getQntLiStoke() +"m3";
	}
	
	public Object clone()  {
		CiterneSecurisee CS;
		CS=(CiterneSecurisee)super.clone();
		CS.TropPlein=(Citerne)TropPlein.clone();
		return CS;
	}
}
 