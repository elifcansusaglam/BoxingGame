import java.sql.SQLOutput;

public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }
    public void start(){
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        if(randomValue<50){
            System.out.println(this.f1.name + "  is started");
            this.f2.health = this.f1.hit(f2);

        }else{
            System.out.println(this.f2.name + "  is started");
            this.f1.health = this.f2.hit(f1);
        }
    }
    public void run() {

        if (checkWeight()) {
            start();
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== NEW ROUND ===========");
                f2.health = f1.hit(f2);
                if (isWin()){
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()){
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Weights are not equal !");
        }


    }


    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Winner is : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Winner is : " + f1.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Remaining life  \t:" + f1.health);
        System.out.println(f2.name + " Remaining life \t:" + f2.health);
    }
}