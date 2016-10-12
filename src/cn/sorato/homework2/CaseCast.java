package cn.sorato.homework2;

/**
 * Created by kongren on 2016/9/22.
 */
public class CaseCast{
    Case casecast;

    public CaseCast(Case casecast){
        this.casecast = casecast;
    }

    public String process(String str){
        boolean flag;
        switch(this.casecast){
            case TO_UPPER:
                flag = true;
                break;
            case TO_LOWER:
                flag = false;
                break;
            default:
                flag = false;
        }
        return process(flag, str);
    }

    private String process(boolean flag, String str){
        StringBuffer sb = new StringBuffer(str);
        if(flag){
            for(int i = 0; i < str.length(); i++){
                char c = sb.charAt(i);
                sb.setCharAt(i, (c >= 'a' && c <= 'z') ? (char) (c - 'a' + 'A') : c);
            }
        }else{
            for(int i = 0; i < str.length(); i++){
                char c = sb.charAt(i);
                sb.setCharAt(i, (c >= 'A' && c <= 'Z') ? (char) (c - 'A' + 'a') : c);
            }
        }
        return sb.toString();
    }

    public enum Case{
        TO_UPPER,
        TO_LOWER
    }
}
