package networkTraffic;

public class Utils {
	public static String byteToHexaString(byte[] a){
		StringBuilder sb = new StringBuilder(a.length);
		for(byte b: a){
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
}
