public class AviaSales implements Comparable<AviaSales> {
    private int id;
    private int price;

    private String from;
    private String to;
    private int time;


    public AviaSales(int id, int price, int time, String from, String to) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }



    @Override
    public int compareTo(AviaSales comparePrice) {
        return this.price - comparePrice.price;
    }
}