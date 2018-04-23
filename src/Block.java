import java.sql.Timestamp;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
public class Block
{
    Data d= new Data();
    String PrevHash;
    String hash;
    String D_Date; //Message
     long TimeStamp=new Date().getTime();

    public Block()
    {

    }

    //SHA-1 ,SHA-224 ,SHA-256,SHA-384,SHA-512,MD2,MD5
    public String generateHash(String Text,String Algorithm) throws NoSuchAlgorithmException {
        String HashValue="";
        byte[] input=Text.getBytes();
        MessageDigest Message=MessageDigest.getInstance(Algorithm);
        Message.update(input);
        byte[] Bytes= Message.digest();
        HashValue=DatatypeConverter.printHexBinary(Bytes).toLowerCase();
        this.hash=HashValue;
        return HashValue;

    }

}
