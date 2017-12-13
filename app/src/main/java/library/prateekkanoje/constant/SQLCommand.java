package library.prateekkanoje.constant;

public abstract class SQLCommand {

    //List cust_pwd from Database

    public static String  Student_Login_QUERY = "select cust_pwd from customer where cust_id=?";

    public static String Ad_login_QUERY = "select ad_pwd from admin where ad_id=?";

    public static String admin_food_query="select f_id,f_name,f_price from food where f_id not in ('f31','f32','f33','f34')";

    public static String menu_cal_price_query="select f_cal,f_price from food where f_name=?";

    public static String admin_orders="select o_id,cust_id,qtyord from orders";


}