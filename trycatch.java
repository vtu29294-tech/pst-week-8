import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private List<String> history;
    private int curr;
    private int max;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        max = 0;
    }
    
    public void visit(String url) {
        curr++;
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        max = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(max, curr + steps);
        return history.get(curr);
    }
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        
        System.out.println(browserHistory.back(1));     
        System.out.println(browserHistory.back(1));     
        System.out.println(browserHistory.forward(1));  
        
        browserHistory.visit("linkedin.com");
        
        System.out.println(browserHistory.forward(2));  
        System.out.println(browserHistory.back(2));     
        System.out.println(browserHistory.back(7));     
    }
}
