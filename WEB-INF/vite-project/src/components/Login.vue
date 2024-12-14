<script>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "Login",
  setup() {
    const router = useRouter();
    // 1 - 登录页 2 - 忘记密码 3 - 注册
    const state = ref(1);

    onMounted(() => {
      console.log(state.value);
    });

    return {
      state,
    };
  },
};
</script>

<template>
  <div class="main">
    <!-- 登录页 -->
    <div class="login-main" v-if="state === 1">
      <div class="login-title">
        <h2>登录</h2>
      </div>
      <div class="login-bottom">
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">用户名</span>
            <input
              type="text"
              class="login_input"
              placeholder="请输入用户名"
              maxlength="20"
            />
          </div>
          <div class="mat-form">
            <a class="login-router" @click="state = 2">忘记用户名</a>
          </div>
        </div>
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">密码</span>
            <input
              type="password"
              class="login_input"
              placeholder="请输入密码"
              maxlength="20"
            />
          </div>
          <div class="mat-form">
            <a class="login-router" @click="state = 2">忘记密码</a>
          </div>
        </div>
        <button class="login-button">
          <span class="login-span">登录</span>
        </button>
        <div class="reg-box">
          <a href="javascript:;">注册</a>
          <ul>
            <li><img src="../assets/GitHub.png" alt="" /></li>
            <li><img src="../assets/QQ.png" alt="" /></li>
            <li><img src="../assets/WeChat.png" alt="" /></li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 找回密码页 -->
    <div class="password-main" v-if="state === 2">
      <div class="password-title">
        <h2>找回密码</h2>
      </div>
      <div class="password-bottom">
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">邮箱</span>
            <input
              type="text"
              class="login_input"
              placeholder="请输入邮箱"
              maxlength="20"
            />
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
            <input
              type="text"
              class="login_input"
              placeholder="请输入验证码"
              maxlength="6"
            />
          </div>
        </div>
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">密码</span>
            <input
              type="password"
              class="login_input"
              placeholder="请输入密码"
              maxlength="20"
            />
          </div>
        </div>
        <div class="login-box">
          <div class="input-wrapper">
            <span class="input-span">确认密码</span>
            <input
              type="password"
              class="login_input"
              placeholder="请输入确认密码"
              maxlength="20"
            />
          </div>
        </div>
        <button class="login-button"  >
          <span class="login-span">修改</span>
        </button>
        <div class="reg-box">
          <a href="javascript:;" @click="state = 1">返回登录 ←</a>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.main {
  width: 600px;
  margin: 0 auto;
  background-color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
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

.password-bottom .login-box:nth-child(1) {
  margin-bottom: 0;
}

.login-main {
  display: flex;
  flex-direction: column;
  padding: 50px;
}

.login-title {
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
  flex-direction: column;
  gap: 10px;
  line-height: 20px;
  margin-bottom: 20px;
}

.input-wrapper {
  display: flex;
}

.input-span {
  width: 80px; /* 固定 span 宽度对齐 */
  color: #333;
  display: flex;
  align-items: center;
}

h2 {
  text-align: center;
  color: #333;
  font-size: 34px;
  margin-bottom: 20px;
}

.login_input {
  flex: 1;
  padding: 10px;
  font-size: 14px;
  outline: none;
}

.login_input:focus {
  border: 2px solid rgb(0, 119, 231);
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
  color: #fff;
}

.login-router {
  color: #3494fc;
}

a {
  cursor: pointer;
}

button {
  cursor: pointer;
}

.get-code {
  text-align: right;
}

.reg-box {
  display: flex;
  justify-content: space-around;
}

.reg-box a {
  font-size: 14px;
  color: gray;
  text-decoration: none;
}

ul,
li {
  list-style: none;
}

.reg-box ul {
  display: flex;
}

.reg-box ul img {
  width: 20px;
  margin-left: 10px;
  cursor: pointer;
}

.code-button {
  height: 30px;
  padding: 5px;
}
</style>