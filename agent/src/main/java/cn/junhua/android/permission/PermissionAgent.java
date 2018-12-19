package cn.junhua.android.permission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import cn.junhua.android.permission.core.AgentCreator;
import cn.junhua.android.permission.impl.AgentCreatorImpl;

/**
 * 权限申请代理类
 *
 * @author junhua.lin@jinfuzi.com<br/>
 * CREATED 2018/12/6 16:44
 */
public class PermissionAgent {

    private PermissionAgent() {
        throw new IllegalStateException("不能实例化");
    }

    public static AgentCreator with(@NonNull View view) {
        return with(view.getContext());
    }

    public static AgentCreator with(@NonNull Context context) {
        if (context instanceof FragmentActivity) {
            return with((FragmentActivity) context);
        } else if (context instanceof Activity) {
            return with((Activity) context);
        } else if (context instanceof ContextWrapper) {
            return with(((ContextWrapper) context).getBaseContext());
        } else {
            throw new IllegalArgumentException("不支持ApplicationContext");
        }
    }

    public static AgentCreator with(@NonNull Activity activity) {
        return new AgentCreatorImpl(activity);
    }

    public static AgentCreator with(@NonNull android.app.Fragment fragment) {
        return new AgentCreatorImpl(fragment.getActivity());
    }

    public static AgentCreator with(@NonNull FragmentActivity fragmentActivity) {
        return new AgentCreatorImpl(fragmentActivity);
    }

    public static AgentCreator with(@NonNull Fragment fragment) {
        return new AgentCreatorImpl(fragment.getActivity());
    }

}