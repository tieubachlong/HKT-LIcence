/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hkt.license;

import java.security.Security;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author BinLe
 */
public class EncryptAES {
    //khóa  mã hóa, giải mã

    private byte[] keyBytes;
    // dữ liệu cần giải mã
    private byte[] dataNeedEncrypt;
    // key giải mã
    private SecretKeySpec key;
    private Cipher cipher;
    private Base32 base32;

    /**
     * Khởi tại Giải mã AES
     * keyBytes: key User truyền vào để làm khóa giải mã(dạng byte)
     * dataNeedEncrypt: dữ liệu cần giải mã
     */
    public EncryptAES(String key, String dataNeedEncrypt) {
        Security.addProvider(new BouncyCastleProvider());
        base32 = new Base32();
        initCipher(key, dataNeedEncrypt);
    }

    private void initCipher(String keyString, String dataNeedEncrypt) {
        //init key and data        
        byte[] keyBytesInput = base32.string32_2_ByteArray(keyString);
        keyBytes = Arrays.copyOf(keyBytesInput, 16);        
        this.dataNeedEncrypt = dataNeedEncrypt.getBytes();
        // init cipher
        try {
            key = new SecretKeySpec(this.keyBytes, "AES");
            cipher = Cipher.getInstance("AES", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * hàm giải mã
     * trả về mảng byte(dữ liệu) được mã hóa
     * @return 
     */
    public String encrypt() {
        try {
            int ctLength = dataNeedEncrypt.length;
            byte[] cipherText = new byte[ctLength];
            System.arraycopy(dataNeedEncrypt, 0, cipherText, 0, cipherText.length);
            byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
            int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
            ptLength += cipher.doFinal(plainText, ptLength);
            byte[] dataAfterEncrypt = new byte[ptLength + 1];
            System.arraycopy(plainText, 0, dataAfterEncrypt, 0, ptLength);
            dataAfterEncrypt[ptLength] = (byte) ptLength;
            return base32.byteArray_2_String32(dataAfterEncrypt);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
