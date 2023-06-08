
public class TestType3 extends Test {
	//apakšklases atributi
	public String atbilde, text, answer="";
	public TestType3(String virsraksts, int id, int tips, String atbilde, String text, String apraksts) {
		super(virsraksts, id, tips, apraksts);
		this.atbilde = atbilde;
		this.text = text;
	}
	
	public void getResult() {
		if (atbilde.compareTo(answer)==0) {
			correct = true;
		}
	}
}
