package httpResponse;

public class LoginAPIResponse {

    private String err;
    private String super_user_auth_token;
    private boolean has_courier_selection;
    private double wallet_balance;
    private String auth_token;
    private String token;
    private boolean has_wallet;

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getSuper_user_auth_token() {
        return super_user_auth_token;
    }

    public void setSuper_user_auth_token(String super_user_auth_token) {
        this.super_user_auth_token = super_user_auth_token;
    }

    public boolean isHas_courier_selection() {
        return has_courier_selection;
    }

    public void setHas_courier_selection(boolean has_courier_selection) {
        this.has_courier_selection = has_courier_selection;
    }

    public double getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(double wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isHas_wallet() {
        return has_wallet;
    }

    public void setHas_wallet(boolean has_wallet) {
        this.has_wallet = has_wallet;
    }


}

