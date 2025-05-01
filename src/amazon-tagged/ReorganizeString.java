import java.util.PriorityQueue;



public class ReorganizeString {

    // without extra space
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for(char ch : s.toCharArray()){
            charCount[ch-'a']++;
        }

        int maxCount=0, letter=0;
        for(int i=0; i<charCount.length;i++){
            if(maxCount<charCount[i]){
                maxCount = charCount[i];
                letter = i;
            }
        }

        if(maxCount>(s.length()+1)/2)
            return "";

        int index=0;
        var ans = new char[s.length()];
        while(charCount[letter]>0){
            ans[index] = (char) (letter + 'a');
            charCount[letter]--;
            index+=2;
        }

        for( int i=0;i<charCount.length;i++){
            while(charCount[i]!=0){
                if(index>s.length()-1){
                    index=1;
                }
                ans[index] = (char) (i + 'a');
                index+=2;
                charCount[i]--;
            }
        }

        return String.valueOf(ans);
    }

    // // Using priority queue
    // public String reorganizeString(String s) {
    //     int[] charCount = new int[26];
    //     for(char ch : s.toCharArray()){
    //         charCount[ch-'a']++;
    //     }

    //     var pq = new PriorityQueue<int[]>((a,b)->Integer.compare(b[1],a[1]));
    //     for(int i = 0;i<26;i++){
    //         if(charCount[i]>0)
    //             pq.offer(new int[]{i+'a',charCount[i]});
    //     }
        
    //     var sb = new StringBuilder();
    //     while(!pq.isEmpty()){
    //         var first = pq.poll();
    //         if(sb.length()==0 || first[0]!=sb.charAt(sb.length()-1)){
    //             sb.append((char)first[0]);
    //             if(--first[1]>0)
    //                 pq.offer(first);
    //         }
    //         else{
    //             if(pq.isEmpty())
    //                 return "";

    //             var second = pq.poll();
    //             sb.append((char)second[0]);
    //             if(--second[1]>0)
    //                 pq.offer(second);

    //             pq.offer(first);
    //         }
    //     }
    //     return sb.toString();
    // }
    
}
