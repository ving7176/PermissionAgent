package cn.junhua.android.permission.special.operation;

import android.content.Context;

import cn.junhua.android.permission.agent.PermissionHandler;

/**
 * 默认同意所有特殊权限
 *
 * @author junhua.lin@jinfuzi.com<br/>
 * CREATED 2019/5/29 14:08
 */
public class DefaultSpecialOperation extends BaseOverlaySpecialOperation {

    @Override
    public void startActivityForResult(PermissionHandler permissionHandler, int requestCode) {
        Context context = permissionHandler.getContext();
        permissionHandler.startActivityForResult(appDetailsIntent(context), requestCode);
    }

    @Override
    public boolean checkPermission(Context context) {
        return true;
    }
}
