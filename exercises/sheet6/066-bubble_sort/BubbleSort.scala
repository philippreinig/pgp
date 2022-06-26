object BubbleSort{
    def swap(arr : Array[Int], i: Int, j: Int) : Unit = {
        val temp = arr(i);
        arr(i) = arr(j);
        arr(j) = temp;
    }

    def bubbleSort(arr : Array[Int]) : Array[Int] = {
        for (n <- arr.length-1 to 0 by -1) {
            for (i <- 0 to n - 1 by 1) {
                if (arr(i) > arr(i + 1)) {
                  swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

    def getLargestRec(arr: Array[Int], i : Int, j : Int) : (Int) = {
        if (i < arr.size) return getLargestRec(arr, i+1, if (arr(i) > arr(j)) i else j);
        else return j;
    }

    def getLargest(arr: Array[Int]) : Int = {
        return getLargestRec(arr, 0, Int.MinValue)
    }

    def bubbleSortRec(arr: Array[Int]) : Array[Int] = {
        return bubbleSortRec(arr, 0);

    }

    def bubbleSortRecIter(arr: Array[Int], n: Int, i: Int) : Array[Int] = {
        if (i == n) return arr;
        if (arr(i) > arr(i+1)){
            swap(arr, i, i+1);
        }
        return bubbleSortRecIter(arr, n, i+1);
    }

    def bubbleSortRec(arr: Array[Int], n: Int) : Array[Int] = {
        if (n <= 1) return arr;
        bubbleSortRecIter(arr, n, 0);
        bubbleSortRec(arr, n-1);
    }


    def main(args: Array[String]) : Unit = {
        var array = Array(5,4,3,7,6,9,1,0);
        var array_str = array.mkString(",");
        println(s"bubbleSort($array_str)= " + bubbleSort(array).mkString(","));
        println(s"bubbleSortRec($array_str)= " + bubbleSortRec(array).mkString(","));

    }
}
