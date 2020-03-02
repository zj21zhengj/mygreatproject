package ioooc.wukong.threadlocal;

/**
 * threadlocal场景2 避免参数传递的麻烦
 *
 * initValue 是适用于 随意控制时
 * set 是用于 不随意控制，比如拦截器生成的
 */
public class ThreadLocalUseage06 {
    public static void main(String[] args) {
        new Service1().process();
    }
}


class Service1 {
    public void process() {
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service2拿到用户名:" + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service3拿到用户名:" + user.name);
        //阿里规约 防止内存泄漏
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
