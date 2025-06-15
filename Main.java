public class Main {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Lion lion = new Lion();
        Fish fish = new Fish();

        rabbit.flee();
        lion.hunt();

        fish.flee();
        fish.hunt();

    }
}
