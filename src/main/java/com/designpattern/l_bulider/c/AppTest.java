package com.designpattern.l_bulider.c;

/**
 * 需求 定义一个电脑类 并且实例化出电脑类的对象，以及给该对象赋值
 *
 * 针对于b包中的问题 修改代码如下
 *    针对于不同的需求，需要创建不同的建造者来生产不同配置的产品
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

//高配
class AdvancedCputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i7 87500HK");
        computer.setGpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("500g固态+2T机械");
        return computer;
    }
}

//中配
class MiddleCputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i7 8300HK");
        computer.setGpu("rtx2080ti");
        computer.setMemory("16g");
        computer.setHd("200g固态+1T机械");
        return computer;
    }
}

//低配
class LowCputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i5 8300HK");
        computer.setGpu("rtx2080ti");
        computer.setMemory("8g");
        computer.setHd("2T机械");
        return computer;
    }
}
//###########################################################################

public class AppTest {
    public static void main(String[] args) {

        AdvancedCputerBuilder acb = new AdvancedCputerBuilder();
        MiddleCputerBuilder mcb = new MiddleCputerBuilder();
        LowCputerBuilder lcb = new LowCputerBuilder();
        //玩游戏
        Computer c = acb.build();
        System.out.println(c);
        //开发
        Computer c2 = mcb.build();
        System.out.println(c2);
        //办公
        Computer c3 = lcb.build();
        System.out.println(c3);
    }


/**
 *这仍然不是建造者模式
 *
 *  优点
 *      可以根据客户端的不同需求，使用不同的建造者来生产产品
 *
 *  缺点
 *      1.我们发现 多个不同建造者中的代码有重复，既然有重复就有了”坏味道“
 *      2.建造的过程不稳定 如果在某个建造者创建产品的过程，漏掉某一步，编译器也不会报错
 *      相当于kfc的某一家制作漏了一步，倒置味道不对
 */
}
