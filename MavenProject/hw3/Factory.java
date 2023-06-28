// 产品接口
interface Product {
    void operation();
}

// 具体产品实现类A
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("具体产品A的操作");
    }
}

// 具体产品实现类B
class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("具体产品B的操作");
    }
}

// 简单工厂类
class SimpleFactory {
    // 根据参数创建具体产品实例
    public static Product createProduct(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ConcreteProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Invalid product type.");
        }
    }
}

// 客户端代码
public class Factory {
    public static void main(String[] args) {
        // 创建具体产品A
        Product productA = SimpleFactory.createProduct("A");
        productA.operation();
        
        // 创建具体产品B
        Product productB = SimpleFactory.createProduct("B");
        productB.operation();
    }
}
