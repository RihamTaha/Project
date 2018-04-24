import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
public class Block
{

    String PrevHash;
    String hash;
//    ArrayList<String> D_Data = new ArrayList<>(); //Message
    String D_Data;
    long TimeStamp;
    int index;

    private int nonce;

    public Block(int index, String Data, String PrevHash)
    {
        this.index = index;
//        this.D_Data.add(Data);
        this.D_Data = Data;
        this.PrevHash = PrevHash;
        this.TimeStamp = new Date().getTime();
        this.nonce = 0;
        try {
            this.hash = this.generateHash("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


//    public void addData(String Data){
//        this.D_Data.add(Data);
//    }

    //SHA-1 ,SHA-224 ,SHA-256,SHA-384,SHA-512,MD2,MD5
    public String generateHash(String Algorithm) throws NoSuchAlgorithmException {       // i think it depends on the block data
        String HashValue;
        String allData = this.index + this.PrevHash + this.TimeStamp + this.D_Data + this.nonce;
        byte[] input = allData.getBytes();
        MessageDigest Message=MessageDigest.getInstance(Algorithm);
        Message.update(input);
        byte[] Bytes= Message.digest();
        HashValue=DatatypeConverter.printHexBinary(Bytes).toLowerCase();
        // this.hash=HashValue;
        return HashValue;
    }

    public void mineBlock(int difficulty) throws NoSuchAlgorithmException{
        String leadingZeros = "";
        for(int i=0; i<difficulty; ++i)
            leadingZeros += "0";
        while(!this.hash.startsWith(leadingZeros)){
            this.nonce++;
            this.hash = this.generateHash("SHA-256");
        }
    }

    public void printBlock(){
        System.out.println("index: " + this.index);
        System.out.println("prev: " + this.PrevHash);
        System.out.println("Data: " + this.D_Data);
        System.out.println("Time Stamp: " + this.TimeStamp);
        System.out.println("hash: " + this.hash);
        System.out.println("");
    }
}
