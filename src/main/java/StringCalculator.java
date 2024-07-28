public class StringCalculator {

    //숫자들
    private int[] nums;

    //operator
    private String[] operator;

    public StringCalculator(final String expression){
        String[] values = expression.split(" ");
        //2 + 3 * 4 / 2
        //values[0]=2
        //values[1]=+
        //values[2]=3
        //values[3]=*
        //values[4]=4
        //values[5]=/
        //values[6]=2

        //필드값 초기화
        nums = new int[values.length/2 + 1];
        operator = new String[nums.length-1];

        if(nums.length ==0) throw new IllegalArgumentException();

        int numsIdx=0;
        int operatorIdx=0;

        for(int i=0;i<values.length;i++){
            if(i==0 || i%2==0)  this.nums[numsIdx++] = Integer.parseInt(values[i]);
            else {
                //연산자가 아니라면
                if(!values[i].equals("+") && !values[i].equals("-") && !values[i].equals("*") && !values[i].equals("/"))
                    throw new IllegalArgumentException();

                this.operator[operatorIdx++] = values[i];
            }
        }

    }

    //계산(calculate) 함수
    int calculate(){
        //2 + 3 * 4 / 2
        //values[0]=2->0
        //values[1]=+->0
        //values[2]=3->1
        //values[3]=*->1
        //values[4]=4->2
        //values[5]=/
        //values[6]=2->3

        int result = nums[0];
        for(int i=0;i<operator.length;i++){
            String operation = operator[i];
            int num2 = nums[i+1];

            switch (operation){
                case "+":
                    result += num2;
                    break;
                case "-":
                    result -= num2;
                    break;
                case "*":
                    result *= num2;
                    break;
                case "/":
                    result /= num2;
                    break;
            }
        }

        return result;
    }
}
