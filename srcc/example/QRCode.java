package example;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import java.security.Security;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class QRCode {

	public static void main(String[] args) throws Exception {
		 // Shto Bouncy Castle si provider
        Security.addProvider(new BouncyCastleProvider());

        // Krijo çelësin privat dhe publik
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EdDSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Mesazhi për të cilin do të nënshkruajmë
        String message = "Pershendetje!";

	// Nënshkruaj mesazhin me qeles privat
        byte[] signature = signMessage(message, keyPair.getPrivate());
        
      }

	 private static byte[] signMessage(String message, java.security.PrivateKey privateKey) throws Exception {
		Signature signature = Signature.getInstance("EdDSA");
		signature.initSign(privateKey);
		signature.update(message.getBytes());
		return signature.sign();
	    }

	
    private static void createQRCode(String data, String filePath) throws WriterException, IOException {
    
    }
}
