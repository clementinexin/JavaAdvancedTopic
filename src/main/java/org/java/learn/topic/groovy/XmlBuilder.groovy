package org.java.learn.topic.groovy

class XmlBuilder {
    def out
    XmlBuilder(out) { this.out = out }
    def invokeMethod(String name, args) {
        out << "<$name>"
        if(args[0] instanceof Closure) {
              args[0].delegate = this  //委托给自己（实际上是设置闭包的上下文）
              args[0].call() //调用该闭包，由于是委托给自己，所以有点递归的味道，实际上不是。
        }
        else {
            out << args[0].toString()
        }
        out << "</$name>"
    }
}