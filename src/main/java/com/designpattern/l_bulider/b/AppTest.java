package com.designpattern.l_bulider.b;


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

class ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i7 87500HK");
        computer.setGpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("500g固态+2T机械");
        return computer;
    }
}

//###############################################################################
public class AppTest {
    public static void main(String[] args) {
        //创建一个建造者
        ComputerBuilder cb = new ComputerBuilder();
        Computer c = cb.build();
        System.out.println(c);
    }
}

/**
    目前这种写法还不是建造者模式
    1.客户端程序员需要一个产品时，直接向建造者要即可，建造者封装了创建电脑的复杂过程

    缺点
        封装的太狠了，无论要什么需求都给你最高的配置，没有选择空间
 **/