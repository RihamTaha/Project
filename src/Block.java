import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
public class Block
{

    String PrevHash;
    String Hash;
    ArrayList<Data>Transactions= new ArrayList<>();
    int nonce;
    long TimeStamp;
    String Message;

    public Block(ArrayList<Data> D , String Prevhash)
    {
        this.PrevHash=Prevhash;
        this.TimeStamp=new Date().getTime();
        this.Transactions=D;
        this.nonce=0;
        try
        {
         this.Hash=this.generateHash("SHA-256");
        }catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }


    public String generateHash(String Algorithm) throws NoSuchAlgorithmException
    {
        String HashValue;
        String allData =  this.PrevHash + this.TimeStamp + this.Message + this.nonce;

        byte[] input = allData.getBytes();
        MessageDigest Message=MessageDigest.getInstance(Algorithm);
        Message.update(input);
        byte[] Bytes= Message.digest();
        HashValue=DatatypeConverter.printHexBinary(Bytes).toLowerCase();

        return HashValue;
    }
    public void Mining_Block(int Difficulty) throws NoSuchAlgorithmException
    {
        String leadingZeros = "";
        for(int i=0; i<Difficulty; ++i)
            leadingZeros += "0";
        while(!this.Hash.startsWith(leadingZeros))
        {
            this.nonce++;
            this.Hash = this.generateHash("SHA-256");
        }
    }

    public void printBlock(){
        System.out.println("prev: " + this.PrevHash);
        System.out.println("Data: " + this.Message);
        System.out.println("Time Stamp: " + this.TimeStamp);
        System.out.println("hash: " + this.Hash);
        System.out.println("");
    }
    public ArrayList<Data> getTransactions() {
        return Transactions;
    }

    public void setTransactions(ArrayList<Data> transactions) {
        Transactions = transactions;

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
