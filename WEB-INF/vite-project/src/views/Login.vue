<template>
    <div class="main">
        <div class="login-main">
            <div class="login-title">
                <h2>登录</h2>
            </div>
            <div class="login-bottom">
                    <div class="login-box">
                        <span>用户名</span>
                        <input type="text" class="login_input" maxlength="20">
                    </div>
                    <div class="login-box">
                        <span>密码</span>
                        <input type="password" class="login_input" maxlength="20">
                    </div>
                    <button class="login-button">
                        <span class="login-span">登录</span>
                    </button>
            </div>
        </div>

    </div>

</template>

<script>

</script>

<style scoped>

.main {
  width: 600px;
  height: 500px;
  margin: 0 auto;
  background: #333;
}

.login-main {
  display: flex;
  flex-direction: column;
}

.login-title{
    margin-bottom: 20px;
    display: flex;
    flex-direction: column;
}

.login-bottom {
  width: 400px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 10px; 
}

.login-box {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 10px; 
  line-height: 40px;
}

span {
  width: 80px; /* 固定 span 宽度对齐 */
  text-align: right; /* 文本靠右对齐 */
  color: white; /* 可选，设置文字颜色 */
}

h2{
    text-align: center;
    color:white;
    font-size: 24px;
    margin: 0;
}

.login_input {
  flex: 1; 
  padding: 5px;
}

.login-button{
  margin: 1em auto;
  width: 80px;
  height: 30px;
}

.login-span{
  font-size: 16px;
  color: #333;
}
</style>