class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Approach 2: Rerverse Decrement
        //The key idea is to find an efficient way to identify the start of a streak. We can achieve this by selecting any card and decrementing the value until we reach a safe streak start.


        //time :O(n)   space:O(n)

        if (hand.length % groupSize != 0) {
            return false;
        }

        // HashMap to store the count of each card value
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count + 1);
        }

        for (int card : hand) {
            int startCard = card;
            // Find the start of the potential straight sequence
            while (cardCount.getOrDefault(startCard - 1, 0) > 0) {
                startCard--;
            }

            // Process the sequence starting from startCard
            while (startCard <= card) {
                while (cardCount.getOrDefault(startCard, 0) > 0) {
                    // Check if we can form a consecutive sequence
                    // of groupSize cards
                    for (int nextCard = startCard;nextCard < startCard + groupSize;nextCard++){
                        if (cardCount.getOrDefault(nextCard, 0) == 0) {
                            return false;
                        }
                        cardCount.put(nextCard, cardCount.get(nextCard) - 1);
                    }
                }
                startCard++;
            }
        }

        return true;
    }
}