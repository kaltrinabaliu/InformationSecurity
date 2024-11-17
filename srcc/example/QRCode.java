package example;
// Importing necessary libraries
// Bouncy Castle library security provider
import org.bouncycastle.jce.provider.BouncyCastleProvider;
// Used for Encoding data in Hex format
import org.bouncycastle.util.encoders.Hex;
//Used for ecurity-related operations
import java.security.Security;
//Used for holding a pair of keys (public and private)
import java.security.KeyPair;
//Used for generating key pairs
import java.security.KeyPairGenerator;
//Used for signing data
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
// Used for specifying the format of the barcode
import com.google.zxing.BarcodeFormat;
// Exception for writing errors
import com.google.zxing.WriterException;
// Used for converting BitMatrix to image
import com.google.zxing.client.j2se.MatrixToImageWriter;
// Used for the QR code matrix
import com.google.zxing.common.BitMatrix;
// Used for generating QR codes
import com.google.zxing.qrcode.QRCodeWriter;
// Used for image input/output
import javax.imageio.ImageIO;
// Used for file handling
import java.io.File;
// Used for handling IO exceptions
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
