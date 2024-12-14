<template>
  <div class="main">
    <div class="password-main">
      <div class="password-title">
        <h2>找回密码</h2>
      </div>
      <div class="password-bottom">
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">邮箱</span>
            <input type="text" class="login_input" placeholder="请输入邮箱" maxlength="20" />
          </div>
          <div class="get-code">
            <button class="code-button">
              <span class="">获取验证码</span>
            </button>
          </div>
        </div>

        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">验证码</span>
            <input type="text" class="login_input" placeholder="请输入验证码" maxlength="6" />
          </div>
        </div>
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">密码</span>
            <input type="password" class="login_input" placeholder="请输入密码" maxlength="20" />
          </div>
        </div>
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">确认密码</span>
            <input type="password" class="login_input" placeholder="请输入确认密码" maxlength="20" />
          </div>
        </div>
        <button class="login-button" @click="updatePassword()">
          <span class="login-span">修改</span>
        </button>
        </div>
    </div>
  </div>
</template>
  
<script>

export default {
  name: "FindPassword",
  methods:{
    updatePassword(){
        console.log('1')
    }
  }

};
</script>

<style scoped>
.main {
  width: 600px;
  height: 500px;
  margin: 0 auto;
  background-color: #fff;
}

.password-main {
  display: flex;
  flex-direction: column;
  padding: 30px;
}

.password-title {

  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
}

.password-bottom {
  width: 400px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.login-box {
  display: flex;
  flex-direction: column;
  gap: 10px;
  line-height: 20px;
}

.input-wrapper {
  display: flex;
}

.input-span {
  width: 70px; /* 固定 span 宽度对齐 */
  color: #333;
  display: flex;
  align-items: center;
}

h2 {
  text-align: center;
  color: #333;
  font-size: 24px;
  margin: 0;
}

.login_input {
  flex: 1;
  padding: 5px;
}

.mat-form {
  display: flex;
  flex-direction: row-reverse;
}

.login-button {
  margin: 1em auto;
  padding: 0 28px;
  line-height: 36px;
  background-color: #3494fc;
  border: none;
  border-radius: 4px;
}

.login-span {
  font-size: 16px;
  color:#fff;
}

.get-code {
  display: flex;
  flex-direction: row-reverse;
}

.code-button {
  padding: 5px;
  height: 30px;
}
</style>
