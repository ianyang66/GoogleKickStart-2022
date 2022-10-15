import java.util.*;


class Solution {
    private static void sortList(List<Integer[]> balls) {
        balls.sort(Comparator.comparingLong(
                a -> Math.abs(a[0]) * (long) Math.abs(a[0]) + Math.abs(a[1]) * (long) Math.abs(a[1]))
        );
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCases = Integer.parseInt(scanner.nextLine());

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {

                Integer[] radii = splitLine(scanner.nextLine());
                long maxDistSquare = ((long) radii[0] + radii[1]) * (radii[0] + radii[1]);

                int n = Integer.parseInt(scanner.nextLine());
                List<Integer[]> ballsN = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    Integer[] ball = splitLine(scanner.nextLine());
                    if (Math.abs(ball[0]) * (long) Math.abs(ball[0]) + Math.abs(ball[1]) * (long) Math.abs(ball[1]) <= maxDistSquare) {
                        ballsN.add(ball);
                    }
                }

                int m = Integer.parseInt(scanner.nextLine());
                List<Integer[]> ballsM = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    Integer[] ball = splitLine(scanner.nextLine());
                    if (Math.abs(ball[0]) * (long) Math.abs(ball[0]) + Math.abs(ball[1]) * (long) Math.abs(ball[1]) <= maxDistSquare) {
                        ballsM.add(ball);
                    }
                }

                if (ballsN.size() == 0) {
                    System.out.println("Case #" + caseNum + ": " + 0 + " " + ballsM.size());
                    continue;
                }
                if (ballsM.size() == 0) {
                    System.out.println("Case #" + caseNum + ": " + ballsN.size() + " " + 0);
                    continue;
                }

                sortList(ballsN);
                sortList(ballsM);

                int resultRed = 0;
                int resultYellow = 0;

                Integer[] closestRed = ballsN.get(0);
                long distRed = closestRed[0] * (long) closestRed[0] + closestRed[1] * (long) closestRed[1];
                Integer[] closestYellow = ballsM.get(0);
                long distYell = closestYellow[0] * (long) closestYellow[0] + closestYellow[1] * (long) closestYellow[1];

                if (distRed < distYell) {
                    resultRed += 1;
                    int idx = 1;
                    while (idx < ballsN.size() &&
                            ballsN.get(idx)[0] * (long) ballsN.get(idx)[0] + ballsN.get(idx)[1] * (long) ballsN.get(idx)[1] < distYell) {
                        resultRed++;
                        idx++;
                    }
                } else {
                    resultYellow += 1;
                    int idx = 1;
                    while (idx < ballsM.size() &&
                            ballsM.get(idx)[0] * (long) ballsM.get(idx)[0] + ballsM.get(idx)[1] * (long) ballsM.get(idx)[1] < distRed) {
                        resultYellow++;
                        idx++;
                    }
                }
                System.out.println("Case #" + caseNum + ": " + resultRed + " " + resultYellow);
            }
        }
    }



    private static Integer[] splitLine(String input) {
        String[] splited = input.split("\\s+");

        Integer[] result = new Integer[splited.length];
        for (int i = 0; i < splited.length; i++) {
            result[i] = Integer.parseInt(splited[i]);
        }
        return result;
    }
}