package Service_user;

import Entities_user.User;




public class Sessions {
    
    private static User loggedInUser = null;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Sessions.loggedInUser = loggedInUser;
    }

}