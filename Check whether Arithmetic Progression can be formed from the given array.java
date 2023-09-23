Using Sorting : time = O(n logn) space = O(1)

  static boolean checkIsAP(int arr[], int n)
    {
        if (n == 1)
            return true;
         
        // Sort array
        Arrays.sort(arr);
         
        // After sorting, difference between
        // consecutive elements must be same.
        int d = arr[1] - arr[0];
        for (int i = 2; i < n; i++)
            if (arr[i] - arr[i-1] != d)
                return false;
         
        return true;
    }


Method - 2 - >  Using HashMap : time = O(n)  space = O(n)

  static boolean checkIsAP(int arr[], int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int smallest = Integer.MAX_VALUE, second_smallest = Integer.MAX_VALUE;
  
    for (int i = 0; i < n; i++) {
 
      // Find the smallest and update second smallest
      if (arr[i] < smallest) {
        second_smallest = smallest;
        smallest = arr[i];
      }
        // Find second smallest
      else if (arr[i] != smallest && arr[i] < second_smallest)
        second_smallest = arr[i];
 
      // if the duplicate element found ,then not possible to make arithmatic progression
      if (!hm.containsKey(arr[i])) {
        hm.put(arr[i], 1);
      }
        // If duplicate found then return false
      else
        return false;
    }
 
    int diff = second_smallest - smallest;
 
    for (int i = 0; i < n - 1; i++) {
      if (!hm.containsKey(second_smallest))
        return false;
      
      second_smallest += diff;
    }
    return true;
  }
