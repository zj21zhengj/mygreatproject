package com.designpattern.l_bulider.e;

/**
 * 需求：定义：定义一个电脑类 ，并且实例化出电脑类的对象，以及给该对象的属性赋值
 *
 *  针对于d包的问题，修改代码如下
 *      建造者模式终于进化出来了
 *
 */


class Computer{
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}

interface ComputerBuilder{
    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();
    Computer build();
}

//高配
class AdvancedCputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        return computer;
    }
    @Override
    public void setCpu() {
        computer.setCpu("1");
    }
    @Override
    public void setGpu() {
        computer.setGpu("1");
    }

    @Override
    public void setMemory() {
        computer.setMemory("1");
    }

    @Override
    public void setHd() {
        computer.setHd("1");
    }


}


//中配
class MiddleCputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        return computer;
    }
    @Override
    public void setCpu() {
        computer.setCpu("2");
    }

    @Override
    public void setGpu() {
        computer.setGpu("12");
    }

    @Override
    public void setMemory() {
        computer.setMemory("2");
    }

    @Override
    public void setHd() {
        computer.setHd("2");
    }
}

//低配
class LowCputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i5 8300HK");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2080ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8g");
    }

    @Override
    public void setHd() {
        computer.setHd("2T机械");
    }

    public Computer build(){
        return computer;
    }
}

//指挥者
class Direcotr{
    public Computer build(ComputerBuilder cb){
        cb.setCpu();
        cb.setGpu();
        cb.setHd();
        cb.setMemory();
        return cb.build();
    }
}

//#############################################################
//客户端建立个中高配
class MiddleHighCputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("---");
    }

    @Override
    public void setGpu() {
        computer.setGpu("---");
    }

    @Override
    public void setMemory() {
        computer.setMemory("---");
    }

    @Override
    public void setHd() {
        computer.setHd("---");
    }

    @Override
    public Computer build() {
        return computer;
    }
}


public class AppTest {
    public static void main(String[] args) {
        AdvancedCputerBuilder acb = new AdvancedCputerBuilder();
        MiddleCputerBuilder mcb = new MiddleCputerBuilder();
        LowCputerBuilder lcb = new LowCputerBuilder();

        Direcotr c = new Direcotr();
        Computer c1 = c.build(acb);
        Computer c2 = c.build(mcb);
        Computer c3 = c.build(lcb);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        MiddleHighCputerBuilder mh = new MiddleHighCputerBuilder();
        Computer c4 = c.build(mh);
        System.out.println(c4);
    }
}


/**
    这就是创建者模式
        1.创建对象的过程稳定不变 因为又接口ComputerBuilder稳定过程
        2.创建对象的过程只写了一次，没有重复代码 指挥者完成
        3.当需要扩展指挥者的时候，不用修改之前的代码，这符合开闭原则

    建造者和工厂模式的 区别
        工厂模式只需要一个简单的 new
        建造者更注重 在new出产品之后 为产品属性赋值的过程

 **/