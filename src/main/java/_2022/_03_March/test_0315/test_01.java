package _2022._03_March.test_0315;

/**
 * @Description
 * @Author XuShen
 * @Date 2022/3/15 13:51
 */
public class test_01 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,0,7,4,9,3};
        int[] index = new int[]{0,1,2,3,4,0,5,1,2,6,7};
        String tel = "";
        for (int i:index){
            tel+=arr[i];
        }
        System.out.println("tel = " + tel);
    }
}
