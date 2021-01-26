package examples.validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

public class DecodeFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String base64Data=Files.readAllLines(Paths.get("E:", "Data.txt")).stream().collect(Collectors.joining()).toString();
			System.out.println(base64Data);
			String normalString=new String(Base64.getDecoder().decode(base64Data.getBytes()));
			String[] lines=normalString.split("\\\\n");
			Arrays.stream(lines).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
