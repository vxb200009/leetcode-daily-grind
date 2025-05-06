public class CompareBkSp {

    public boolean backspaceCompare(String s, String t) {
        int s_len = s.length()-1, t_len = t.length()-1;
        int skipS=0,skipT=0;
        while(s_len>=0 || t_len>=0){

            while(s_len>=0){
                if(s.charAt(s_len)=='#') {skipS++; s_len--;}
                else if(skipS>0){skipS--; s_len--;}
                else break;
            }


            while(t_len>=0){
                if(t.charAt(t_len)=='#') {skipT++; t_len--;}
                else if(skipT>0){skipT--; t_len--;}
                else break;
            }

            if(s_len>=0 && t_len>=0 && s.charAt(s_len)!=t.charAt(t_len))
                return false;

            if((s_len<0 || t_len<0)&& !(s_len<0 && t_len<0))
                return false;
            s_len--;t_len--;
        }
        return true;
    }
    
}
