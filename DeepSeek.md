```text
使用java对deepseek api的简易对接
```
# 配置
[application.yml](src/main/resources/application.yml)
```yaml
deepseek:
  model: [模型类型]
  api-key: [自己的API key]
  url: [deepseek的api url]
```

# 项目结构
- common：通用模块，包含异常处理，返回值处理，返回值封装类
- controller：控制层
- entity：实体层
- service：服务层，通过OkHttps发起请求，并响应
