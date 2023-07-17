# Markdown Tutorials
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题

*斜体文本*
_斜体文本_
**粗体文本**
__粗体文本__
***粗斜体文本***
___粗斜体文本___

***
___
* * *
_ _ _
--------

~~删除线~~

<u>下划线</u>
    
脚注[^脚注]
[^脚注]: 上标索引，相当于注释。

* 无序列表第一项
* 无序列表第二项
* 无序列表第三项
+ 无序列表第一项
+ 无序列表第二项
+ 无序列表第三项
- 无序列表第一项
- 无序列表第二项
- 无序列表第三项

1. 有序列表第一项
2. 有序列表第二项
3. 有序列表第三项  
4. 列表嵌套第一项
    - 列表嵌套第一项的第一个元素
    - 列表嵌套第一项的第二个元素
5. 列表嵌套第二项
    - 列表嵌套第二项的第一个元素
    - 列表嵌套第二项的第二个元素

> 区块引用
> 最外层
> > 第一层嵌套
> > > 第二层嵌套

> 区块中使用列表
> 1.第一项
> 2.第二项
> + 第一项
> + 第二项
> + 第三项

* 列表中使用区块
    > 问君何不乘风起
    > 扶摇直上九万里
* 列表中使用区块

`printf()`函数

int minCostToMoveChips(vector<int>& position) {
    vector<int> dp(position.size(), 0);
    int res = INT_MAX;
    for(int i = 0; i < dp.size(); i++){
        int pos = position[i];
        int sum = 0;
        for(int j = 0; j < dp.size(); j++){
            sum += ((abs(position[j] - pos))%2);
        }
        res = min(res, sum);
    }
    return res;
}

```C++
int minCostToMoveChips(vector<int>& position) {
    vector<int> dp(position.size(), 0);
    int res = INT_MAX;
    for(int i = 0; i < dp.size(); i++){
        int pos = position[i];
        int sum = 0;
        for(int j = 0; j < dp.size(); j++){
            sum += ((abs(position[j] - pos))%2);
        }
        res = min(res, sum);
    }
    return res;
}
```

[链接名称](链接地址)
或者
<链接地址>
这是一个链接[LinkedIn](https://www.linkedin.com/in/ian-anfu-liu)
<https://www.linkedin.com/in/ian-anfu-liu>

这个链接用 1 作为网址变量 [Google][1]
这个链接用 Baidu 作为网址变量 [百度][Baidu]
然后在文档结尾作为变量赋值

上标： 
n<sup>2</sup> + 1
下标：
log<sub>2</sub>n

[1]:https://www.google.com/
[Baidu]:https://www.baidu.com/
