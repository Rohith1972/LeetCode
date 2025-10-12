class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }else if(c == '['){
                countStack.push(num);
                stringStack.push(currentString);
                currentString="";
                num = 0;
            }else if(c == ']'){
                int repeatCount = countStack.pop();
                String prevString = stringStack.pop();
                currentString = prevString + currentString.repeat(repeatCount);
            }else{
                currentString += c;
            }
        }
        return currentString;
    }
}