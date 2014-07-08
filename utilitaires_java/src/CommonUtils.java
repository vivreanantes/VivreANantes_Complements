
public class CommonUtils {

	public static String getRessourcesPath (Class aClass, String replace) {
		String result = aClass.getProtectionDomain().getCodeSource().getLocation().getFile();
		result = result.replace("/bin", replace);
		return result;
	}
	static String esc(String string) {

		if (string.indexOf(',') != -1)
			string = '"' + string + '"';
		return string;
	}
}
