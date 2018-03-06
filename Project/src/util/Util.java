package util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Util {

	public static String convertMD5(String password) {
		try {

			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes;

				bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));

			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			System.out.println(result);
			return result;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;


	}

}
