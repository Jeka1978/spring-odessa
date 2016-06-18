package mailServer;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class MailInfo {
    private int code;
    private String name;

    public MailInfo(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
