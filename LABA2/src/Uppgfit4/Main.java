package Uppgfit4;

public class Main {

    public static void main(String[] args) {
        ArrayQueue<Object> planesLanding = new ArrayQueue<>(1000000);
        ArrayQueue<Object> planesAscending = new ArrayQueue<>(1000000);
        ArrayQueue<Long> planesLandingTimer = new ArrayQueue<>(1000000);
        ArrayQueue<Long> planesAscendingTimer = new ArrayQueue<>(1000000);

        int runwayTimer = 0;

        double totalStartingWait = 0;
        double totalLandingWait = 0;
        int amountPlanesAscended = 0;
        int amountPlanesLanded = 0;
        long maxWaitLanding = 0;
        long maxWaitStarting = 0;

        double year10 = 10 * 365 * 24 * 60;
        long timer = 0;

        while (timer < year10) {
            timer++;

            if (timer % 5 == 0) {
                if (Math.random() <= 0.05) {
                    planesAscending.offer("Plane");
                    planesAscendingTimer.offer(timer);
                }
                if (Math.random() <= 0.05) {
                    planesLanding.offer("Plane");
                    planesLandingTimer.offer(timer);
                }
            }

            if (runwayTimer > 0) {
                runwayTimer--;
            }

            if (runwayTimer == 0) {
                if (!planesLanding.isEmpty()) {
                    long waitTime = timer - planesLandingTimer.poll();
                    planesLanding.poll();

                    totalLandingWait += waitTime;
                    maxWaitLanding = Math.max(maxWaitLanding, waitTime);
                    amountPlanesLanded++;

                    runwayTimer = 20;
                }
                else if (!planesAscending.isEmpty()) {
                    long waitTime = timer - planesAscendingTimer.poll();
                    planesAscending.poll();

                    totalStartingWait += waitTime;
                    maxWaitStarting = Math.max(maxWaitStarting, waitTime);
                    amountPlanesAscended++;

                    runwayTimer = 20;
                }
            }
        }

        System.out.println("Medelväntetid landning: " + (totalLandingWait / amountPlanesLanded) + " min");
        System.out.println("Medelväntetid start: " + (totalStartingWait / amountPlanesAscended) + " min");
        System.out.println("Maximal väntetid landning: " + maxWaitLanding + " min");
        System.out.println("Maximal väntetid start: " + maxWaitStarting + " min");
    }
}