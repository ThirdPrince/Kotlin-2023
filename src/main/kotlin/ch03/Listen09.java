package ch03;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/**
 * 代码3-9
 * java 调用 挂起函数
 * 书 40页
 */
public class Listen09 {
    public static void main(String[] args) {
        Object result = Listen08Kt.notSuspend(new Continuation<Integer>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resumeWith(@NotNull Object o) {

            }
        });
    }
}
