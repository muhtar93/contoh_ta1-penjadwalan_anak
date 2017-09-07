package sfk.project.com.scheduleforkids.config;

/**
 * Created by Toshiba-PC on 7/16/2016.
 */
public class Config {
    //Address of our scripts of the CRUD
    public static final String URL_LOGIN= "http://familytask.000webhostapp.com/familytask/register/login.php";
    public static final String URL_ADD="http://familytask.000webhostapp.com/familytask/register/registerOrtu.php";

    /*public static final String URL_GET_ALL = "http://mob-ukmimdev.esy.es/im4sil/getAllEmp.php";
    public static final String URL_GET = "http://mob-ukmimdev.esy.es/im4sil/getEmp.php?id=";
    public static final String URL_UPDATE = "http://mob-ukmimdev.esy.es/im4sil/updateEmp.php";
    public static final String URL_DELETE = "http://mob-ukmimdev.esy.es/im4sil/deleteEmp.php?id=";*/

    public static final String USER_NAME = "USER_NAME";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_ID = "id_ortu";
    public static final String KEY_NAME = "nama_ortu";
    public static final String KEY_USERNAME = "username_ortu";
    public static final String KEY_EMAIL = "email_ortu";
    public static final String KEY_PASSWORD = "password_ortu";
    public static final String KEY_FOTOPROFIL = "fotoprofil_ortu";
    public static final String KEY_TEMPAT = "tempat_lahir";
    public static final String KEY_TANGGAL = "tanggal_lahir";

    //JSON Tags
    public static final String TAG_ID = "id_ortu";
    public static final String TAG_NAME = "nama_ortu";
    public static final String TAG_USERNAME = "username_ortu";
    public static final String TAG_EMAIL = "email_ortu";
    public static final String TAG_PASSWORD = "password_ortu";
    public static final String TAG_FOTOPROFIL = "fotoprofil_ortu";
    public static final String TAG_TEMPAT = "tempat_lahir";
    public static final String TAG_TANGGAL = "tanggal_lahir";

    //employee id to pass with intent
    public static final String ID = "emp_id";
}
