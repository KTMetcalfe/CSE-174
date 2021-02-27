public class test {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        System.out.println(cantMakeIt(arr));
    }

    public static int cantMakeIt(int[] nums) {
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            System.out.printf("i1: %d\n", i);
            for (int j = i; j < nums.length; j++) {
                System.out.printf("i2: %d\n", i);
                if (temp < total) {
                    System.out.print(temp);
                    temp += nums[j];
                    System.out.print(" " + nums[j] + " " + temp + " " + total + "\n");
                } else if (temp > total) {
                    System.out.printf("went over\n");
                    break;
                }
                if (temp == total){
                    System.out.println(total);
                    total++;
                    i = -1;
                    break;
                }
            }
            System.out.printf("i3: %d\n", i);
        }
        return total;
    }
}
