package randomNumbers;

import java.text.NumberFormat;
import java.util.Random;

public class drawNumbersProbabilities {
    public static int drawRandomNumber()
    {
        Random randomNumber = new Random();
        int result;
        // P(1) = 0.2, P(2) = 0.3, P(3) = 0.5
        int number = randomNumber.nextInt(101); // [0, 100]

        if (number <= 20) // [0;20] -> 0.2 probability
        {
            result = 1;
        }
        else if (number <= 50) // [21;50] -> 0.3 probability
        {
            result = 2;
        }
        else // [51,100] -> 0.5 probability
        {
            result = 3;
        }
        return result;
    }

    public static double calculateNumberProbability(int frequency, int timesDrawn)
    {
        return (double)frequency / (double)timesDrawn;
    }

    public static void main(String[] args) {
        // formatter for printing percents
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);

        int freq1 = 0; // used to count frequency of drawing 1
        int freq2 = 0; // used to count frequency of drawing 2
        int freq3 = 0; // used to count frequency of drawing 3

        // testing with looping 10,000 times
        int drawCount = 10000;
        for (int i = 0; i< drawCount; i++) // drawing 10,000 times
        {
            int number = drawRandomNumber(); // drawing random number [1;3] with pre set probability for each.
            switch (number)
            {
                case 1:
                    freq1++;
                    break;
                case 2:
                    freq2++;
                    break;
                case 3:
                    freq3++;
                    break;
                default:
                    break;
            }
        }

        // calculating the probability that each number have been drawn
        double oneProbability = calculateNumberProbability(freq1, drawCount);
        double twoProbability = calculateNumberProbability(freq2, drawCount);
        double threeProbability = calculateNumberProbability(freq3, drawCount);

        // printing detailed result
        System.out.printf("Results of generating 10,000 times:\n" +
                        "Number 1 has been drawn %d times with probability: %.3f -> %s\n" +
                "Number 2 has been drawn %d times with probability: %.3f -> %s\n" +
                "Number 3 has been drawn %d times with probability: %.3f -> %s\n",
                freq1, oneProbability, percentFormat.format(oneProbability),
                freq2, twoProbability, percentFormat.format(twoProbability),
                freq3, threeProbability, percentFormat.format(threeProbability));

        // resetting values for test 2, 60,000 draws
        freq1 = 0; freq2 = 0; freq3 = 0;
        drawCount = 60000;

        for (int i = 0; i< drawCount; i++) // drawing 60,000 times
        {
            int number = drawRandomNumber(); // drawing random number [1;3] with pre set probability for each.
            switch (number)
            {
                case 1:
                    freq1++;
                    break;
                case 2:
                    freq2++;
                    break;
                case 3:
                    freq3++;
                    break;
                default:
                    break;
            }
        }
        oneProbability = calculateNumberProbability(freq1, drawCount);
        twoProbability = calculateNumberProbability(freq2, drawCount);
        threeProbability = calculateNumberProbability(freq3, drawCount);

        System.out.printf("Results of generating 60,000 times:\n" +
                        "Number 1 has been drawn %d times with probability: %.3f -> %s\n" +
                        "Number 2 has been drawn %d times with probability: %.3f -> %s\n" +
                        "Number 3 has been drawn %d times with probability: %.3f -> %s\n",
                freq1, oneProbability, percentFormat.format(oneProbability),
                freq2, twoProbability, percentFormat.format(twoProbability),
                freq3, threeProbability, percentFormat.format(threeProbability));
    }
}
