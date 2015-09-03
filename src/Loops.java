/**
 * Created by dashenka on 12.08.15.
 */
public class Loops {

        public int[][] task1(final int limit) {
            // BEGIN
            int[][] triangleArray = new int[limit][];
            for (int i = 0; i < limit; i++){
                triangleArray[i] = new  int[i];
                for (int j = 0; j < i; j++){
                    triangleArray[i][j] = i;
                }
            }
            return triangleArray;
            // END

        }

        public int task2(final int[] m, final int target) {
            // BEGIN
            /*for (int i = 0;i < m.length; i++) {
                if (m[i] == target) {
                return i;
            }
            }
            return -1;*/
            int i = 0;
            while(i < m.length && m[i] != target) i++;
            if (i == m.length) return -1;
            return i;
            // END

        }

        public void task3(final int[] m, final int from, final int to) {
            // BEGIN
            for (int i = 0; i < m.length; i++) {
                if (m[i] == from) {

                    m[i] = to;
                }
            }
            // END

        }


}
