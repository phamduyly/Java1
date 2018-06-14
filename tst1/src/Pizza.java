
public class Pizza {
    private String name;
    private double price;

    public Pizza (String x, double y){
        name = x;
        price = y;
    }

    private String getInfor(){
        String a = name + price;
        return a;
    }

    private String getName() {
        return name;
    }

    private double getPrice() {
        return price;
    }



}


