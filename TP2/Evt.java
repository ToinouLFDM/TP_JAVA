public class Evt {

	private String chNom;
	private String chLieu;
	private Date chDate;
	private static int chNbrEvt;


	public Evt(String parNom, String parLieu, Date parDate){
		chNom=parNom;
		chLieu=parLieu;
		chDate=parDate;
		chNbrEvt++;

	} 

	public String getNom() {
		return chNom;
	}

	public String getLieu() {
		return chLieu;
	}
	public Date getDate() {
		return chDate;
	}
	public void setNom(String parNom){
		chNom=parNom;
	}
	public void setLieu(String parLieu){
		chLieu=parLieu;
	}
	public void setDate(Date parDate) {
		chDate=parDate;
	}
	public static int getChNbrEvt() {
		return chNbrEvt;
	}

	public String toString() {
		return chNom + " a " + chLieu + " le " + chDate.toString(); 
	}

	public static Evt lireEvt() {

		String _nom;
		String _lieu;
		Date _date;

		_nom=Clavier.lireString();
		_lieu=Clavier.lireString();
		_date=Date.lire_Date();

		Evt res= new Evt(_nom,_lieu,_date);
		return res;
	}

	public int compareTo (Evt parEvt) {
		if(chNom.compareTo(parEvt.chNom)==1) 
			return 1;
		else if(chNom.compareTo(parEvt.chNom)==0){
			if(chLieu.compareTo(parEvt.chLieu)==1)
				return 1;
			else if(chLieu.compareTo(parEvt.chLieu)==0) {
				if(chDate.compareToDate(parEvt.chDate)==1)
					return 1;
				else if(chDate.compareToDate(parEvt.chDate)==0)
					return 0;
				return -1;
			}
			return -1;
		}
		return -1;
	}

}