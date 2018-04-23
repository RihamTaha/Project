public class Data {
    String From;
    String To;
    float amount;

    public Data(String from, String to, float amount) {
        From = from;
        To = to;
        this.amount = amount;
    }

    public Data() {
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
