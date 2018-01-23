public class Date {
	private int chJour;
	private int chMois;
	private int chAn;
	
	public Date() {
		chJour=23;
		chMois=1;
		chAn=2013;
	}
	public Date(int parJour,int parMois, int parAn) {
		chJour=parJour;
		chMois=parMois;
		chAn=parAn;
	}
	public Date(Date parDate) {
		chJour=parDate.getJour();
		chMois=parDate.getMois();
		chAn=parDate.getAn();
	}
	public int getJour() {
		return chJour;
	}
	public int getMois() {
		return chMois;
	}
	public int getAn() {
		return chAn;
	}
	public String toString() {
		return (getJour() + "/" + getMois() + "/" +getAn()) ;
	}
	public int dernierJourDuMois() {
		switch(chMois) {
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
				
			case 2:
				if( (chAn%4==0 && chAn%100!=0) || chAn%400==0)
					return 29;
				else 
					return 28;
					
			default:		
				return 31;
		}
	}
	
	public boolean estValide() {
		if(chAn<1583)
			return false;
		if(chMois<1 || chMois>12)
			return false;
		if(chJour<1 || chJour>dernierJourDuMois() )
			return false;
		return true;
	}
	public void lire_Date() {
		boolean done =false;
		Clavier clavier= new Clavier();
		while(!done) {
			System.out.println("Entrez le Jour ");
			chJour=clavier.lireInt();
			System.out.println("Entrez le Mois ");
			chMois=clavier.lireInt();
			System.out.println("Entrez l'Année");
			chAn=clavier.lireInt();
			if(this.estValide() )
				done=true;
		}
	}
	public int compareToDate(Date parDate) {
		if(parDate.getAn()<chAn)
			return 1;
		else if(parDate.getAn()==chAn) {
			if(parDate.getMois()<chMois)
				return 1;
			else if(parDate.getMois()==chMois) {
				if(parDate.getJour()<chJour)
					return 1;
				if(parDate.getJour()==chJour)
					return 0;
				if(parDate.getJour()>chJour)
					return -1;
			}
			return -1;
		}
		return-1;
	}
	public Date dateDuLendemain() {
		Date res = new Date();
		res=this;
		if(chJour==dernierJourDuMois()) {
			res.chJour=1;
			if(chMois==12) {
				res.chMois=1;
				res.chAn+=1;
			}
			else 
				res.chMois+=1;
		}
		else
			res.chJour+=1;
			
		return res;
	}
	public Date dateDeLaVeille() {
		Date res = new Date();
		res=this;
		if(chJour==1) {
			if(chMois==1) {
				res.chMois=12;
				res.chAn-=1;
			}
			else 
				res.chMois-=1;
			res.chJour=dernierJourDuMois();
		}
		else
			res.chJour-=1;
			
		return res;
	}
	
}


