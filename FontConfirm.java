import java.awt.*;

class FontConfirm {
	public static void main(String[] args) {
		String[] str = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}