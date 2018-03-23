package getapps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jyc.appfuncdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyongchao on 3/22.
 * recyclerview 的适配器
 */

public class AppInfoAdapter extends RecyclerView.Adapter<AppInfoAdapter.ViewHolder> {

    private List<AppInfo> mApps;  //存储所有app的链表

    public AppInfoAdapter(ArrayList<AppInfo> data) {
        this.mApps = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView appName;
        TextView packageName;
        TextView className;

        public ViewHolder(View view) {
            super(view);
            icon = view.findViewById(R.id.app_icon);
            appName = view.findViewById(R.id.app_name);
            packageName = view.findViewById(R.id.packagename);
            className = view.findViewById(R.id.classname);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppInfo appInfo = mApps.get(position);
        holder.icon.setImageDrawable(appInfo.getAppIcon());
        holder.appName.setText(appInfo.getAppName());
        holder.packageName.setText("包名：" + appInfo.getPackageName());
        holder.className.setText("类名：" + appInfo.getClssName());
    }

    @Override
    public int getItemCount() {
        return mApps == null ? 0 : mApps.size();
    }

}
