TestUserDAO，展示的是Mapper CRUD接口的方法  
TestUserService 展示的是Service CRUD接口的方法  
两者都存在许多已经设定好，直接可用的方法，用谁都可以  
  
所有已有的可用的方法，详见官方文档：https://mp.baomidou.com/guide/crud-interface.html  
  
mybatis-Plus的方法，可以主键自生成，可以回填  
User user = new User();  
user.setName("...").setAge(..).setEmail("...");    
int result = userMapper.insert(user);  
System.out.println(user); 此时user可回填主键id  
  
  
MP乐观锁需要数据库表有version字段  


