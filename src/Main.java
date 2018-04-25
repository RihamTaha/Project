import java.security.NoSuchAlgorithmException;

public class Main
{
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        try {
            System.out.println("Mining block 1...");
            blockchain.addBlock(new Block(1, "Samir give Mansout floos tany", ""));

            System.out.println("Mining block 2...");
            blockchain.addBlock(new Block(2, "Samir take his money back from Mansour", ""));

            blockchain.printBlocks();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
