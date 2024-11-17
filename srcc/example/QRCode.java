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
	   // Adding Bouncy Castle as a security provider

       	    Security.addProvider(new BouncyCastleProvider());

            // Generating a new key pair using EdDSA algorithm
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EdDSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

           // Message to be signed and encoded in the QR code
            String message = "Pershendetje, nga grupi 7 lenda Siguria e informacionit- FIEK!";

	    // Sign the message using the private key
            byte[] signature = signMessage(message, keyPair.getPrivate());
            // Create a QR code containing the message and its signature
	    createQRCode(message + " | Signature: " + Hex.toHexString(signature), "QRCode.png");

        
      }
       //Method to sign a message using a private key
       private static byte[] signMessage(String message, java.security.PrivateKey privateKey) throws Exception {
	    Signature signature = Signature.getInstance("EdDSA");
	    signature.initSign(privateKey);
	    signature.update(message.getBytes());
	    return signature.sign();
	    
       }

       // Method to create a QR code from the given data and save it to a file
       private static void createQRCode(String data, String filePath) throws WriterException, IOException {
           QRCodeWriter qrCodeWriter = new QRCodeWriter();
           BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);

           File qrCodeFile = new File(filePath);
           ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "PNG", qrCodeFile);
           System.out.println("QR Code i krijuar në: " + qrCodeFile.getAbsolutePath());
    }
}
