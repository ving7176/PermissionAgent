package cn.junhua.android.permission.agent;

import cn.junhua.android.permission.agent.callback.OnDeniedCallback;
import cn.junhua.android.permission.agent.callback.OnGrantedCallback;
import cn.junhua.android.permission.agent.callback.OnRationaleCallback;

/**
 * 申请权限相关操作
 *
 * @author junhua.lin@jinfuzi.com<br/>
 * CREATED 2018/12/6 17:01
 */
public interface Agent<T> {

    /**
     * 一般情况下不需要设置
     * 当默认值与你项目的code重复时，可以选择设置新的requestCode
     *
     * @param requestCode requestCode
     */
    Agent<T> code(int requestCode);

    /**
     * 当用户同意权限时候的操作
     */
    Agent<T> onGranted(OnGrantedCallback<T> onGrantedCallback);

    /**
     * 当用户拒绝权限时候的操作
     */
    Agent<T> onDenied(OnDeniedCallback<T> onDeniedCallback);

    /**
     * <p>
     * 仅在用户已拒绝某项权限请求时提供解释。
     * 如果用户继续尝试使用需要某项权限的功能，但继续拒绝权限请求，
     * 则可能表明用户不理解应用为什么需要此权限才能提供相关功能。
     * 对于这种情况，比较好的做法是显示解释。
     * </p>
     * 当shouldShowRequestPermissionRationale()返回true是起作用
     */
    Agent<T> onRationale(OnRationaleCallback<T> rationale);


    /**
     * 执行请求操作
     */
    void apply();
}
