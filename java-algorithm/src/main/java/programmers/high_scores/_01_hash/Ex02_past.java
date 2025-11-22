package programmers.high_scores._01_hash;

class Solution02 {
    public boolean solution(String[] phone_book) {
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book.length;j++){
                if(phone_book[j].indexOf(phone_book[i]) == 0 && i != j){
                    return false;
                }
            }
        }

        return true;
    }
}

public class Ex02_past {
}
