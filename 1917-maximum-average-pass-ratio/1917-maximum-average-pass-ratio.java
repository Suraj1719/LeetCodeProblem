class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //Approach 1: Brute Force (Time Limit Exceeded Error) : time=O(k*n) space=O(n)

        // List<Double> passRatios = new ArrayList<>();

        // // Calculate initial pass ratios
        // for (int classIndex = 0; classIndex < classes.length; classIndex++) {
        //     double initialRatio =
        //         (double) classes[classIndex][0] / classes[classIndex][1];
        //     passRatios.add(initialRatio);
        // }

        // while (extraStudents > 0) {
        //     List<Double> updatedRatios = new ArrayList<>();

        //     // Calculate updated pass ratios if an extra student is added
        //     for (
        //         int classIndex = 0;
        //         classIndex < classes.length;
        //         classIndex++
        //     ) {
        //         double newRatio =
        //             (double) (classes[classIndex][0] + 1) /
        //             (classes[classIndex][1] + 1);
        //         updatedRatios.add(newRatio);
        //     }

        //     int bestClassIndex = 0;
        //     double maximumGain = 0;

        //     // Find the class that gains the most from an extra student
        //     for (
        //         int classIndex = 0;
        //         classIndex < updatedRatios.size();
        //         classIndex++
        //     ) {
        //         double gain =
        //             updatedRatios.get(classIndex) - passRatios.get(classIndex);
        //         if (gain > maximumGain) {
        //             bestClassIndex = classIndex;
        //             maximumGain = gain;
        //         }
        //     }

        //     // Update the selected class
        //     passRatios.set(bestClassIndex, updatedRatios.get(bestClassIndex));
        //     classes[bestClassIndex][0]++;
        //     classes[bestClassIndex][1]++;

        //     extraStudents--;
        // }

        // // Calculate the total average pass ratio
        // double totalPassRatio = 0;
        // for (double passRatio : passRatios) {
        //     totalPassRatio += passRatio;
        // }

        // return totalPassRatio / classes.length;


        //Approach 2: Priority Queue  : Time complexity: O(k⋅log(n)+n) space=O(n)

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
            Double.compare(b[0], a[0])
        );

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                new double[] {
                    calculateGain(passes + 1, totalStudents + 1),
                    passes + 1,
                    totalStudents + 1,
                }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
            (double) (passes + 1) / (totalStudents + 1) -
            (double) passes / totalStudents
        );
    }
}