import java.util.LinkedList;

public class Test {
	//Virsklases Test atributi
	public String virsraksts, apraksts;
	public int id, tips;
	public boolean correct=false;
	public Test(String virsraksts, int id, int tips, String apraksts) {
		this.virsraksts = virsraksts;
		this.id = id;
		this.tips = tips;
		this.apraksts = apraksts;
		
	}
	public static void result(LinkedList<Object> taskArray) {
		for (Object element : taskArray) {
			if (element instanceof TestType1) {
				((TestType1) element).getResult();
			}
			else if (element instanceof TestType2) {
				((TestType2) element).getResult();
			}
			else {
				((TestType3) element).getResult();
			}
		}
		
	}
	
	
	
}
