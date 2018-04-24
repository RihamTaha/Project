import java.util.ArrayList;

public class Blockchain
{
    ArrayList<Block>blockChain= new ArrayList<>();

    public Boolean isValid()
    {
        Block Previous_Block;
        Block Current_Block;

        Boolean Prev=false;
        Boolean Curr=false;
        Boolean D=false;
        for(int k=1; k<blockChain.size();k++)
        {
           D=false;
            Current_Block=blockChain.get(k);
            Previous_Block=blockChain.get(k-1);
            if(Current_Block.hash==blockChain.get(k).hash)
            {
                Curr=true;
            }
            if(Previous_Block.hash==blockChain.get(k).PrevHash)
            {
                Prev=true;
            }
            if(Prev&& Curr)
            {
                D=true;
            }

        }
        return D;

    }
}
