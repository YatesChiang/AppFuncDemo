package getapps;

import android.graphics.drawable.Drawable;

/**
 * Created by jiangyongchao on 3/22.
 * 存储App信息，如包名、类名等信息
 */


public class AppInfo {

    public String appName = "";
    public String packageName = "";
    public String clssName = "";
    public Drawable appIcon = null;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClssName() {
        return clssName;
    }

    public void setClssName(String clssName) {
        this.clssName = clssName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }
}
