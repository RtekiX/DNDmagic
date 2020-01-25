import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class test {
	public static void main(String args[]) throws IOException {

		Pattern pattern = Pattern.compile(
				" <P class=MsoNormal style=\"LAYOUT-GRID-MODE: char; TEXT-ALIGN: left; MARGIN: 0cm 0cm 0pt; mso-line-height-alt: 0pt; mso-pagination: widow-orphan\" align=left>\r\n"
						+ "      <SPAN lang=EN-US style=\"FONT-FAMILY: '微软雅黑','sans-serif'\">\r\n"
						+ "        <o:p>&nbsp;</o:p></SPAN>\r\n" + "    </P>");
		File file = new File("D:/NAVI/DND/text.txt");
		FileInputStream inputStream = new FileInputStream(file);
		int size = inputStream.available();
		byte[] buffer = new byte[size];
		inputStream.read(buffer);
		inputStream.close();
		String str = new String(buffer, "UTF-8");
		String[] arr;
		arr = pattern.split(str);
		System.out.println(arr[50]);
	}
}
