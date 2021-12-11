package tp1_Exercice1_Interfaces;


public class MonTableau implements  EstComparable {
	private int [] tab;
	
	public MonTableau(int [] tab) {
		this.tab=tab;
	}

	public int somme() {
		int sum=0;
		for(int i=0;i<this.tab.length;i++)
			sum=sum + this.tab[i];
		return sum;
	}

    public int compareA(Object o) throws RuntimeException {
    	int result;
    	try {
    		if (o==null)
    		{
    			result=1;
    			throw new NullPointerException();
    		}
    		else if((o instanceof MonTableau)==false)
    		{
    			result=2;
    			throw new ClassCastException();
    		}
    		else 
    		{
    		    MonTableau temp;
        	    temp=(MonTableau)o;
        	    if (this.somme()<temp.somme())
        		   result=-1;
        	    else if(this.somme()==temp.somme())
        		   result=0;
        	    else
        	  	   result=1;
    	        return result;
    		}
    		
    	}catch(NullPointerException e) 
    	{
    		System.out.print("Attention l’objet passé en paramètre est Null. l'exception n°:");
    		return 1;
    	}
    	catch(ClassCastException e) 
    	{
    		System.out.print("Attention l’objet passé en paramètre est d’une classe ne permettant pas d’effectuer la comparaison avec une instance de MonTableau. l'exception n°:");
    	    return 2;
    	}
    }
}