import java.security.NoSuchAlgorithmException;

public class Main
{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Blockchain BC=new Blockchain();
        Data L=new Data("Riham","Eslam",175);

       // System.out.println("L.M: "+L.Message);
        BC.Add_Transactions(L);
        //System.out.println("---->>>"+BC.Transactions.get(0).amount);

        //System.out.println(BC.Transactions.size());
        System.out.println("For the First Time");
        BC.Mining_Chain("ٌRiham");
        System.out.println("====================================================" +BC.CheckBalance("Riham"));

        System.out.println("For the Second Time");
         Data K=new Data("Eslam","Riham",50);
        BC.Add_Transactions(K);
        BC.Mining_Chain("ٌRiham");
        System.out.println("====================================================" +BC.CheckBalance("Riham"));
       /* System.out.println("The Second Time");
        BC.Mining("FCI");
        System.out.println( BC.CheckBalance("FCI"));*/

    }


}
