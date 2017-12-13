package library.prateekkanoje.constant;



/**
 * Constants related to database file
 * Such as file path and file name
 */
public abstract class DBConstant
{
    //database file directory filePath=DatabaseConstant.DBPATH+context.getPackageName()+"/databases/"+DatabaseConstant.DBNANME
    public static String DATABASE_PATH = "/data/data/library.prateekkanoje/databases";
    //database file name
    public static String DATABASE_FILE = "DBprojects.db";
    //database version
    public static int DATABASE_VERSION = 1;
}

