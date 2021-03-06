// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package demo.bean;


import demo.util.UITools;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

/**
 * @author Bogdan Buzac
 * @since 2013.12.12
 */

@ManagedBean
public class LoginBean extends AbstractBackingBean {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private String username;
    private String password;

    public LoginBean() {
    }

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Login action
     */
    public String loginAction() {
        String action = null;
        String msg = null;
        FacesMessage facesMsg = null;

        if (USERNAME.equalsIgnoreCase(getUsername()) &&
            PASSWORD.equalsIgnoreCase(getPassword())) {
            action = "next";
/*
            msg = "Success.  Your user name is \'" + getUsername() +
                  "\' and your password is \'" + getPassword() + "\'";

            UITools.addSuccessMessage(getContext(), msg);
*/
        } else {
            action = "failed";
            msg = "Failure. Your user name is \'" + getUsername() +
                  "\' and your password is \'" + getPassword() + "\'." +
                   " Try user: admin, pass: admin";

            UITools.addErrorMessage(getContext(), msg);
        }

        return action;
    }

}