public class TestEvt {

	public static void main(String args[]){
		Evt evt1= new Evt("TP1", "IUT",new Date(1,1,2018));
		Evt evt2= new Evt("TP1", "IUT",new Date(1,1,2018));
		Evt evt3= new Evt("TP3", "IUT",new Date(3,1,2018));

		System.out.println(Evt.getChNbrEvt());
		System.out.println(evt1.compareTo(evt2));

	}

}