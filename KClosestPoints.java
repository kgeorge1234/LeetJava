import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(
            (b[0]*b[0]+b[1]*b[1]),
            (a[1]*a[1]+a[0]*a[0])
            )
            );
        
            for (int[] point : points) {
                maxHeap.add(point);
                if (maxHeap.size() > k) {
                    maxHeap.remove();
                }
            }
             
            int[][] result = new int[k][2];
            while (k-- > 0) {
                result[k] = maxHeap.remove();
            }
            return result;
    }

    public static void main(String[] args) {
        
        KClosestPoints k = new KClosestPoints();
        int [][] result = k.kClosest(new int[][]{{1,3},{-2,2}},1);
    }
}

