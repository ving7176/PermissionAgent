package cn.junhua.android.permission.special;

import cn.junhua.android.permission.special.operation.DefaultSpecialOperation;

/**
 * 特殊权限操作工厂
 *
 * @author junhua.lin@jinfuzi.com<br/>
 * CREATED 2019/5/29 10:35
 */
public interface SpecialOperationFactory {

    /**
     * 创建不同版本的特殊权限操作实例
     * 返回null就是用默认权限操作{@link DefaultSpecialOperation}
     *
     * @return SpecialOperation
     */
    SpecialOperation create();

}
