package Testing;

import java.util.List;

public class MyThread extends Thread {
    private boolean found = false;
    private String password;
    private List<String> passwords;
    public MyThread(String password,List<String> passwords){
        this.passwords = passwords;
        this.password = password;
    }
    public void run(){
        char[] guessPassword = new char[password.length()];
        generatePassword(guessPassword,password);
    }
    public void generatePassword(char[] guessPassword,String password){
        generatePassword(guessPassword,0,password);
    }
    public void generatePassword(char[] guessPassword,int index,String password){
        if (found)
            return;
        for (short i='0';i<='z';i++){
            char c = (char)i;
            if (!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index] = c;
            if(index!=guessPassword.length-1){
                generatePassword(guessPassword, index+1, password);
            }
            else{
                String guess = new String(guessPassword);  //把字符数组变为字符串
                passwords.add(guess);
                if (guess.equals(password)){
                    System.out.println("找到了,密码是"+guess);
                    found = true;
                    return;
                }
            }
        }
    }
}
