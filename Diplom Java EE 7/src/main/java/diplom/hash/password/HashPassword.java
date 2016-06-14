package diplom.hash.password;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HashPassword {
	
	public static String hashPass(String pass)
	{
		return Hashing.sha256().hashString(pass, Charsets.UTF_8).toString();
	}

}
