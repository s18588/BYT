public class Main {

    public static void main(String args[]){

        var pool = new Pool();
        var car1 = pool.checkOut();
        var car2 = pool.checkOut();
        var car3 = pool.checkOut();

        pool.checkIn(car1);
        pool.checkIn(car3);

        var car4 = pool.checkOut();
    }
}
