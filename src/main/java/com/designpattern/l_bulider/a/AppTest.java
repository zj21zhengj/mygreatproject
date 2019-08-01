package com.designpattern.l_bulider.a;

/**
 * 建造者模式
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

//#######################################################################################

public class AppTest  {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.setCpu("i7 7500u");
        c.setGpu("gt940mx");
        c.setMemory("16g");
        c.setHd("1T机械");
        System.out.println(c);
    }
}

/**
 * 这样做法的缺点是
 *  1，客户端程序员 在实例化产品后产品的对象后，必须为该对象的每一个属性赋值，太麻烦了
 *  违反了迪比特法则 （最少知道原则）
 *  
 */
