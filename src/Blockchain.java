import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain
{
    ArrayList<Block>blockChain= new ArrayList<>();
    int difficulty;

    public Blockchain(){
        this.blockChain.add(new Block(0,"Samir give Mansour floos kteeer", "0"));
        this.difficulty = 5;
    }

    public Boolean isValid()
    {
        Block Previous_Block;
        Block Current_Block;

        Boolean curr, prev;

        for(int k=1; k<blockChain.size();k++)
        {
            Current_Block = blockChain.get(k);
            Previous_Block = blockChain.get(k-1);

            try {
                curr = (Current_Block.hash == blockChain.get(k).generateHash("SHA-256"));
                prev = (Previous_Block.hash == blockChain.get(k).PrevHash);

                if(!(curr && prev))
                    return false;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void addBlock(Block b) throws NoSuchAlgorithmException {
        b.PrevHash = this.blockChain.get(this.blockChain.size() -1).hash;
        b.mineBlock(this.difficulty);
        this.blockChain.add(b);
    }

    public void printBlocks(){
        for (Block b: this.blockChain) {
            b.printBlock();
        }
    }
}
