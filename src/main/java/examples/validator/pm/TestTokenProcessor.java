package examples.validator.pm;

public class TestTokenProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="path/to/another/location/of/file";
		TokenProcessor tp= new TokenProcessor("path/**/**/file");
		if(tp.startsWithPattern()) {
			String currentToken=tp.currentToken();
			int ctIdx=url.indexOf(currentToken);
			String data=url.substring(0,ctIdx);
			System.out.println(data);
		}
		while(tp.hasMoreTokens()) {
			String currentToken=tp.currentToken();
			System.out.println("currentToken>>"+currentToken);
			if(tp.isEndToken()) {
				break;
			}
			String nextTokenToken=tp.nextToken();
			if(currentToken!=null && nextTokenToken!=null) {
				int ctIdx=url.indexOf(currentToken);
				int ntIdx=url.indexOf(nextTokenToken);
				String data=url.substring((ctIdx+currentToken.length()),ntIdx);
				System.out.println(data);
			}

		}
		if(tp.endsWithPattern()) {
			String currentToken=tp.previousToken();
			System.out.println("previousToken>>"+currentToken);
			int ctIdx=url.indexOf(currentToken);
			String data=url.substring(ctIdx+currentToken.length());
			System.out.println(data);
		}
	}

}
