import java.util.*;

public class canMeasureWater {
    public static boolean canMeasureWater(int x,int y,int z){
        //3.21水壶问题
        if(x == z || y == z || x + y == z){
            return true;
        }
        if(x + y  <  z){
            return false;
        }
        Set<List<Integer>> visited = new HashSet<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        List<Integer> init = Arrays.asList(0,0);

        res.add(init);
        visited.add(init);
        while(res != null){
            List<Integer> cur = res.poll();
            int cur_x = cur.get(0);
            int cur_y = cur.get(1);
            if(cur_x == z || cur_y == z || cur_x + cur_y == z){
                return true;
            }
            //给x加满水
            List<Integer> s1 = Arrays.asList(x,cur_y);
            if(!visited.contains(s1)){
                res.add(s1);
                visited.add(s1);
            }

            //给y加满水
            List<Integer> s2 = Arrays.asList(cur_x,y);
            if(!visited.contains(s2)){
                res.add(s2);
                visited.add(s2);
            }

            //清空x中的水
            List<Integer> s3 = Arrays.asList(0,cur_y);
            if(!visited.contains(s3)){
                res.add(s3);
                visited.add(s3);
            }

            //清空y中的水
            List<Integer> s4 = Arrays.asList(cur_x,0);
            if(!visited.contains(s4)){
                res.add(s4);
                visited.add(s4);
            }

            //从x向y倒水
            int tmp_x = cur_x + cur_y <= y ? 0 : cur_x - (y - cur_y);
            int tmp_y = cur_x + cur_y <= y ? cur_y + cur_x : y;
            List<Integer> s5 = Arrays.asList(tmp_x,tmp_y);
            if(!visited.contains(s5)){
                res.add(s5);
                visited.add(s5);
            }

            //从y向x倒水
            tmp_x = cur_x + cur_y <= x ? cur_x + cur_y : x;
            tmp_y = cur_x + cur_y <= x ? 0 : cur_y - (x - cur_x);
            List<Integer> s6 = Arrays.asList(tmp_x,tmp_y);
            if(!visited.contains(s6)){
                res.add(s6);
                visited.add(s6);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        canMeasureWater(3,5,4);
    }
}
