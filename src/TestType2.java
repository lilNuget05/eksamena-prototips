import java.util.Arrays;

public class TestType2 extends Test {
	//apakšklases atributi
	public int atbildes;
	public String[] varianti;
	public boolean[] answers;
	public TestType2(String virsraksts, int id, int tips, int atbildes, String[] atbilzuMasivs, String apraksts) {
		super(virsraksts, id, tips, apraksts);
		this.atbildes = atbildes;
		this.varianti = atbilzuMasivs;
		this.answers = new boolean[varianti.length];
		for(int i=0;i<varianti.length;i++) {
			answers[i] = false;
		}
			
	}
	public void getResult() {
		boolean[] array = new boolean[answers.length];
		for (int i=0;i<answers.length;i++) {
			if (i<=atbildes) {
				array[i] = true;
			}
			else {
				array[i] = false;
			}
		}
		
		if (Arrays.equals(array, answers)) {
			correct = true;
		}
		
	}
}
