public class isRectangleOverlap {
    //3.18矩形重叠
    public static boolean isRectangleOverlap(int[] rec1,int[] rec2){
        //矩形如果不重叠，从x轴和y轴上看两个矩形就变成了两条线段，这两条线段肯定是不相交的
        //也就是rec2在rec1的上、下、左、右
        return !(rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);

    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        isRectangleOverlap(rec1,rec2);
    }
}
