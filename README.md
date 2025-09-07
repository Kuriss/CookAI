# CookAI - 智能厨房助手

## 项目简介

CookAI 是一个基于通义千问大模型的智能厨房助手系统，旨在帮助用户合理利用现有食材，提供个性化菜谱推荐、营养搭配建议和烹饪指导。

## 技术栈

### 后端
- **Java**: JDK 17
- **框架**: Spring Boot 3.5.5
- **构建工具**: Maven 3.9.9
- **数据库**: MySQL 8.0 + Redis 7.0
- **AI模型**: 通义千问大模型

### 前端
- **框架**: Vue 3 + Vite
- **UI库**: Element Plus
- **状态管理**: Pinia
- **HTTP客户端**: Axios

## 项目特性

- 🍽️ **智能菜谱推荐**: 基于现有食材和个人喜好推荐菜谱
- 🥗 **营养分析**: 提供菜品营养成分分析和健康建议
- 🛒 **智能购物清单**: 自动生成采购建议和食材替代方案
- 👨‍🍳 **烹饪指导**: 分步骤烹饪指导和实用小贴士
- 📱 **个性化服务**: 用户偏好学习和历史记录管理

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.9.9+
- Node.js 18+
- MySQL 8.0+
- Redis 7.0+

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/your-team/cookai.git
cd cookai
```

## API文档

启动后端服务后，可通过以下接口进行测试：

- `GET /api/test/hello` - 服务健康检查
- `POST /api/recipes/recommend` - 菜谱推荐
- `GET /api/ingredients` - 获取食材列表
- `POST /api/users/preferences` - 用户偏好设置

## 部署说明

### 生产环境部署
1. 后端打包: `mvn clean package`
2. 前端打包: `npm run build`
3. 配置nginx反向代理
4. 启动服务

---

**CookAI Team** - 让烹饪变得更智能 🚀
