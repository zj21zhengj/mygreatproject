package com.designpattern.l_bulider.d;

/**
 * 需求 定义一个电脑类 并且实例化出电脑类的对象，以及给该对象赋值
 *
 * 针对于c包中的问题 修改代码如下
 *    创建一个建造者接口，把制作的产品的具体步骤，稳定下来
 *    我们让建造者类，去实现建造者接口，接口中的方法步骤，类必须都要实现，少实现一个抽象方法
 *    就会报错
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
//###########################################################################
public class AppTest{
    public static void main(String[] args) {
        AdvancedCputerBuilder acb = new AdvancedCputerBuilder();
        MiddleCputerBuilder mcb = new MiddleCputerBuilder();
        LowCputerBuilder lcb = new LowCputerBuilder();
        //玩游戏
        acb.setCpu();
        acb.setGpu();
        Computer c = acb.build();
        System.out.println(c);
        //开发
        mcb.setCpu();
        Computer c2 = mcb.build();
        System.out.println(c2);
        //办公
        lcb.setMemory();
        Computer c3 = lcb.build();
        System.out.println(c3);
    }
}

/**
    这还不是建造者模式
        优点
            建造者过程是稳定的，不会漏掉一步 这样客户端建造也不会漏掉

        缺点
            1.代码仍然有重复
            2.现在又变成了客户端自己配置电脑 又违反了迪米特法则 这相当于你去配电脑
            虽然不用你自己亲自组装，但是你必须指挥装机boy去安装 。。
 **/