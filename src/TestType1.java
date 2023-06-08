
public class TestType1 extends Test {
	//apakšklases atributi
	public int atbilde, answer=0;
	public String[] varianti;
	public TestType1(String virsraksts, int id, int tips, int atbilde, String[] atbilzuMasivs, String apraksts) {
		super(virsraksts, id, tips, apraksts);
		this.atbilde = atbilde;
		this.varianti = atbilzuMasivs;
	}
	public void getResult() {
		if (atbilde==answer) {
			correct = true;
		}
	}

}
