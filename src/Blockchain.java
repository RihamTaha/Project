import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain
{

    ArrayList<Block>BlockChain= new ArrayList<>();
    ArrayList<Data>Transactions= new ArrayList<>();

    int diffculty;
    int Mining_Reward;

    public Blockchain()
    {
        this.Mining_Reward=250;
        this.diffculty=5;
        this.Transactions=new ArrayList<>();
        this.BlockChain= new ArrayList<>();
        this.BlockChain.add(this.Create_Genesis_Block());
    }

    public  Block Create_Genesis_Block()
    {
        Data D= new Data("","",0);
        ArrayList<Data>DD= new ArrayList<>();
        DD.add(D);
        Block B= new Block(DD,"0000");
        return B;
    }
    public  void AddBlock(Block B) throws NoSuchAlgorithmException
    {

        System.out.println(B.Transactions.get(0).amount);
        B.PrevHash=this.BlockChain.get(this.BlockChain.size()-1).Hash;
        B.Mining_Block(this.diffculty);
        this.BlockChain.add(B);
    }

    public void Mining_Chain(String Mining_Reward_Address) throws NoSuchAlgorithmException
    {
        Block LastBlock=this.BlockChain.get(this.BlockChain.size()-1);
        Block B= new Block(this.Transactions,LastBlock.Hash);
        //System.out.println(B.Transactions.get(0).Message);
        B.Mining_Block(this.diffculty);
        this.BlockChain.add(B);

        Data T= new Data("",Mining_Reward_Address,this.Mining_Reward);
        this.Transactions= new ArrayList<Data>();
        this.Transactions.add(T);
    }
    public void Add_Transactions(Data D)
    {
        this.Transactions.add(D);
    }

    public int CheckBalance(String Address)
    {
        int Balance=0;

        //System.out.println("BC SIZE: "+BlockChain.size());
        for(int i=0; i<BlockChain.size();i++)
        {

            Balance=0;
            //System.out.println("Size: "+this.getTransactions().size());
            for(int j=0; j<this.BlockChain.get(i).getTransactions().size();j++)
            {
              /*  System.out.println("Message: "+this.getTransactions().get(j).Message);
                System.out.println("***************************");
                System.out.println("From: "+this.getTransactions().get(j).From);
                System.out.println("To: "+this.getTransactions().get(j).To);
                System.out.println("amount: "+this.getTransactions().get(j).amount);
                System.out.println("***************************");*/

                if(this.BlockChain.get(i).getTransactions().get(j).From==Address)
                {
                    Balance-= this.BlockChain.get(i).getTransactions().get(j).amount;
                    //System.out.println("Balance- : "+Balance);
                   //return Balance;
                }
                 else if(this.BlockChain.get(i).getTransactions().get(j).To==Address)
                {
                    Balance+= this.BlockChain.get(i).getTransactions().get(j).amount;
                    //System.out.println("Balance+ : "+Balance);
                    //return Balance;
                }
            }
        }
        return Balance;
    }

    public Boolean isValid()
    {
        Block Previous_Block;
        Block Current_Block;

        Boolean curr, prev;

        for(int k=1; k<BlockChain.size();k++)
        {
            Current_Block = BlockChain.get(k);
            Previous_Block = BlockChain.get(k-1);

            try {
                curr = (Current_Block.Hash == BlockChain.get(k).generateHash("SHA-256"));
                prev = (Previous_Block.Hash == BlockChain.get(k).PrevHash);

                if(!(curr && prev))
                    return false;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void printBlocks(){
        for (Block b: this.BlockChain) {
            b.printBlock();
        }
    }


    public ArrayList<Block> getBlockChain() {
        return BlockChain;
    }

    public void setBlockChain(ArrayList<Block> blockChain) {
        BlockChain = blockChain;
    }

    public ArrayList<Data> getTransactions() {
        return Transactions;
    }

    public void setTransactions(ArrayList<Data> transactions) {
        Transactions = transactions;
    }
}
