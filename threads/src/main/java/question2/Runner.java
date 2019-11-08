package question2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {

    private String name;
    private int routeLength;
    private int restTime;
    private float restProbability;

    public Runner(String name, int routeLength, int restTime) {
        this.name = name;
        this.routeLength = routeLength;
        this.restTime = restTime;
        this.restProbability = (((float)(0.5 * routeLength) - (float)restTime) / (float)routeLength) * 100;
        System.out.println("probabilidade do corredor " + name + " descansar: " + restProbability);
    }

    @Override
    public void run() {
        try {
            while (routeLength > 0) {
                if(willRest()) {
                    System.out.println("O corredor " + name + " esta descansando");
                    Thread.sleep(restTime * 1000);
                }
                System.out.println("Faltam " + routeLength + " metros para o corredor " + name);
                routeLength--;
            }
            System.out.println("O corredor " + name + " chegou!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Boolean willRest() {
        return ThreadLocalRandom.current().nextInt(0, 100) < restProbability;
    }
}
