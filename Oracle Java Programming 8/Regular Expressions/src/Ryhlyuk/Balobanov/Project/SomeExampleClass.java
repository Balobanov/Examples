package Ryhlyuk.Balobanov.Project;

public class SomeExampleClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegExParse rg = new RegExParse();
		
		/*List<Product> prod = rg.getListProduct(rg.readHTML("source.html"));
		System.out.println(prod);*/
		
		rg.getListName(rg.readHTML("baby2008.html"));
	}
		
}
