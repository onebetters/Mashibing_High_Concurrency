package com.basic.chapter0200;

/**
 * 简介
 * 指导性思想（极其重要）
 * 第一步：考虑问题域中有哪些类，哪些对象
 * 第二步：这些个类，这些个对象有哪些个属性
 * 第三步：考虑类与类之间的关系，定他们之间的方法
 *
 * 分析问题域方法
 * 类，成员变量（属性）：找名词
 * 方法（函数）：找动词
 *
 * 万事万物皆对象
 * 追求：
 *      重用，可扩展性(多态)，可维护性，面向组件（二进制级别抽象）的编程，WebService，SOA，COM
 *
 * @author MarkShen1992
 * @since 20191104
 */
public class Chapter0200Introduction {
    public static void main(String[] args) {
        /**
         * 编程语言的发展
         * 面向过程设计思想
         *      一切以我为中心
         *      我第一步要干什么；
         *        第二步要干什么；
         *        ......
         *
         * 面向对象设计思想
         *      车 go(新疆)，车怎么去，我不知道，最合适的方法应该出现在最合适的类里面，
         *      车最知道自己的内部结构。在程序内，不在分解一步一步的过程，而是在问题域
         *      里应该有哪些个对象，对象里面应该有哪些属性（静），哪些方法（动），对象
         *      与对象之间的关系。
         *
         * 对象和类的概念
         *      类是抽象的：具有某些特征的东西。一类事物的抽象。静态的属性
         *          瓶子能倒水
         *      对象是具体的，对应着数据库中的一条记录
         *
         * 类之间的关系
         *      依赖 < 关联（我这个方法的参数是你这个类的对象） < 聚合 < 组合
         *      为 设计模式 打基础
         *      继承：...是一种..., extends
         *      聚合：整体与局部的关系，...是...的一部分。
         *      组合：密不可分，...是...必不可少的一部分。
         *      UML图
         *      实现关系：implements
         *      多态：
         *          存在继承关系；
         *          方法重写
         *          父类引用指向子类对象
         *
         * 对象和引用
         *      引用：Java语言中除基本类型之外的变量类型都称为引用类型。
         *      Java堆内存中的对象是通过栈内存中的引用对其操作的
         *      占两块儿内存，堆内存，栈内存
         *
         * Java类的定义
         * 构造函数(析构函数)
         *      public 类名() {}
         *      new 一个东西的时候要调用的方法，叫做构造方法。
         *      一旦你自己重写构造方法，那么Java 编译器将不会为这个类添加默认的构造方法
         *      所以，我们在new对象的时候，我们要做到的就是把那个无参的构造方法
         *      手动加上
         *
         * 对象的创建和使用
         *      Object o = new Object();
         *      o.equals(new Object);
         *
         * this 关键字
         *      当前对象
         *      this(String...) 对应的构造方法
         *      this.methodName 本类方法
         *
         * super 关键字
         *      调用父类的内容
         *      super(String...) 对应父类构造函数
         *      super.methodName 父类方法
         *
         * static 关键字
         *      类变量
         *      类方法
         *
         * package 关键字
         *      解决类名冲突的问题
         *      命名：公司域名倒过来，默认为default包
         *      包对应文件系统中的文件夹
         *      根据业务分包
         *      根据功能分包
         *      如果向让别的人用你的类，首先要先用 import 关键字将其引入
         *
         * import 关键字
         *      引入别的类库
         *
         * 访问控制 public protected private 友好
         * 对于成员变量如下表：
         * 修饰符       类内部     同一个包     子类      任何地方
         * public        Y           N          N          N
         * default       Y           Y          N          N
         * protected     Y           Y          Y          N
         * public        Y           Y          Y          Y
         *
         * 对于类来说
         *  public：任何地方都可以使用这个类
         *  default
         *
         * 类的继承 extends
         *      特别注意下 protected 关键字
         *      双亲委派机制
         *      子类对象包含父类对象
         *
         * 方法的重写 @Override
         *      从父类继承
         *      相同的函数名称
         *      相同的参数列表
         *      相同的方法返回值
         *      重写方法的时候要去父类copy, 也可以使用工具生成
         *      重写的方法不可以使用比被重写方法更严格的访问权限
         *
         * final 关键字
         *      类似于C语言中的 const
         *      在内存中的 数据 区
         *      被 final 修饰的变量不能被修改
         *          成员变量
         *          局部变量 (形参)
         *      final 的方法不能被重写
         *      final 的类不能被继承
         *
         * Object 类
         * https://docs.oracle.com/javase/8/docs/
         *      Java 根基类
         *      多看JavaAPI
         *      toString() 方法
         *      equals方法
         *
         * 对象转型
         *      父类引用指向子类对象
         *      一个基类的引用不可以访问其子类对象新加的成员（属性和方法）
         *      可以使用 引用变量 instanceof 类名，来判断该引用类型变量所指向的对象是否
         *      属于该类或该类的子类
         *      子类的对象可以当作基类的对象来使用称上转型(upcasting),反之，称为下转型
         *
         *      扩展性比较好的例子：
         *      当你建好这个建筑后，或者你写好这个程序之后，把主建筑建好了，将来要加一些
         *      其他的功能，尽量不要去修改主结构，叫扩展性好
         *      多看 经典建筑方面的书籍，比如巴黎圣母院的重新设计
         *
         *      亮了！巴黎圣母院的新塔尖设计方案
         *      http://dy.163.com/v2/article/detail/EET5G1F70528UJ6I.html
         *      https://zhuanlan.zhihu.com/p/77317713
         *
         * 多态
         *      存在继承关系
         *      方法重写
         *      父类引用指向子类对象
         *      实际中new的谁，就调用谁的方法，函数指针，动态绑定，核心中的核心
         *
         * 抽象类 Abstract
         *      用 abstract 修饰的类为抽象类， 修饰的方法为 抽象方法
         *      抽象方法没有必要实现
         *
         *      // 相当于 C ++ 中的纯虚函数
         *      public abstract void method();
         *      当一个类中有抽象方法的时候，那么这个类必须被声明为抽象类，抽象类
         *      必须被继承，抽象方法必须被重写
         *      抽象类不可以 new 出对象
         *      抽象类只需声明，不需要实现
         *
         * 接口 interface implements
         *      多个无关的类可以实现同一个接口
         *      一个类可以实现多个无关的接口
         *      与继承关系类似，接口与实现类之间存在多态性
         *
         *      接口是抽象方法和常量值的定义的集合，接口是一种特殊的抽象类，这种抽象类中
         *      只包含常量和方法的定义，而没有变量和方法的实现。
         *
         *      public static final int id = 1;
         *      为什么要定义成 public static final 吗？为了修正 c++ 中多继承时候，容易
         *      出现问题的地方。c++ 的多继承容易出现：类的多个父类之间，如果有相同的成员
         *      变量的时候，引用起来相当麻烦，运行时候产生各种各样的问题。
         *
         *      接口的特性：
         *      1. 接口可以多重实现
         *      2. 接口中声明的属性默认为 public static final 的，也只能是 public static final的
         *      3. 接口中只能定义抽象方法，这些接口默认为 public 的，也只能是 public 的
         *      4. 接口可以继承其他接口，并添加新的属性和成员方法
         *
         *      接口中定义的方法：函数指针
         *
         *
         *      总结：
         *          1. 内存分析贯穿始终
         *          2. 对象和类的概念
         *          3. 类（对象）之间的关系
         *          4. 面向对象设计思想
         *          5. class
         *          6. new
         *              引用的概念
         *              构造方法的概念
         *          7. 方法重载
         *              构造方法重载
         *          8. this
         *          9. static
         *          10. package & import
         *          11. private default protected public
         *          12. extends
         *          13. override
         *          14. final
         *          15. Object
         *               toString
         *               equals
         *          16. upcasting downcasting
         *          17. Polymorphism/dynamic binding/late
         *          18. abstract class
         *          19. interface
         *               implements
         */
    }
}