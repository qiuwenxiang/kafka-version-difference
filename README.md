# kafka-version-difference
#### kafka默认端口9092，在CloudManager的CDH-Hadoop中一致，在ambari的HDP-hadoop中改为6667端口
- 0.8.2.0 版本
    - producer consumers  为scala实现
    - 依赖kakfa_XXX 包
    - consumers 分为high-level simple-level 偏移量保存进zk
- 0.9.X.X 版本
    - 引入安全机制
    - 依赖kafka-clients包
    - producer,consumers 由java重写，去除scala,zk依赖
    - producer 取消同步异步 ，统一为异步， acks机制
    - consumers 取消high ,simple，统一由__consumer_offsets 保存偏移量
    
