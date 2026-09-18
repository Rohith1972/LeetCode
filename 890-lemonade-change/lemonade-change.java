class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0,five = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>=1){
                    ten++;
                    five--;
                }else{
                    System.out.println(five);
                    System.out.println(ten);
                    return false;
                }
            }else{
                if(five>=1 && ten>=1){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -= 3;
                }else{
                    System.out.println(five);
                    System.out.println(ten);
                    return false;
                }
            }
        }
        return true;
    }
}