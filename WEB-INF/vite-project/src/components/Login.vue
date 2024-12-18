<script setup>
import { getCurrentInstance, onMounted, ref,reactive } from "vue";
import { useRouter } from "vue-router";
import VerifyUtils from '@/utils/Verify.js'

// 创建路由
const router = useRouter();
// 1 - 登录页 2 - 忘记密码 3 - 注册
const state = ref(1);
const username = ref("");
const password = ref("");
const nickname = ref("");
const email = ref("");
const confirmPasswrod = ref("");
const apiurl = "http://localhost:8081";

// 切换页面时清空输入框内容
const switchPage = (page) => {
  state.value = page;
  console.log(state.value)

  username.value = "";
  password.value = "";
  nickname.value = "";
  email.value = "";
  confirmPasswrod.value = "";
}

// 错误信息
const errorMessage = ref("");

// 登录
const login = () => {
  if (!username.value || !password.value) {
    alert("用户名和密码不能为空！");
    return;
  }

  // 提交的数据
  const user = {
    username: username.value,
    password: password.value,
  };

  // 调用接口
  fetch(apiurl + "/api/user/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  })
    .then((response) => response.json())
    .then((data) => {
      // 将返回的 token 存进 本地存储
      localStorage.setItem("token", data.data.token);
    });
};

// 注册
const rigster = () => {
  errorMessage.value = ""; // 每次提交前清空错误提示

  if(!username.value || !nickname.value || !email.value){
    alert("请填写完整信息")
    return
  } else if(!password.value || ! confirmPasswrod.value ){
    alert("密码不能为空")
  } else if(password.value != confirmPasswrod.value){
    alert("两次密码不一致")
  }
}

// 页面加载完成时执行
onMounted(() => {
  // console.log(state.value);
});
</script>

<template>
  <div class="main">
    <!-- 登录页 -->
    <form @submit.prevent="login">
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
                v-model="username"
              />
            </div>
            <div class="mat-form">
              <a class="login-router" @click="switchPage(2)">忘记用户名</a>
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
                v-model="password"
              />
            </div>
            <div class="mat-form">
              <a class="login-router" @click="switchPage(2)">忘记密码</a>
            </div>
          </div>
          <button class="login-button" type="submit">
            <span class="login-span">登录</span>
          </button>
          <div class="reg-box">
            <span>第三方登录/注册</span>
            <div class="right-image">
              <button class="mat-focus-img">
                <img src="@/assets/image/WeChat.png" alt="" />
              </button>
              <button class="mat-focus-img">
                <img src="@/assets/image/QQ.png" alt="" />
              </button>
              <button class="mat-focus-img">
                <img src="@/assets/image/Github.png" alt="" />
              </button>
            </div>
          </div>
          <div class="login-reg-box">
            没有账号，
            <a href="javascript:;" @click="switchPage(3)">注册</a>
          </div>
        </div>
      </div>
    </form>
    <!-- 注册页 -->
    <form @submit.prevent="rigster">
      <div class="login-main" v-if="state === 3">
        <div class="login-title">
          <h2>注册</h2>
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
                v-model="username"
              />
            </div>
          </div>
          <div class="login-box">
            <div class="input-wrapper">
              <span class="input-span">昵称</span>
              <input
                type="text"
                class="login_input"
                placeholder="请输入昵称"
                maxlength="20"
                v-model="nickname"
              />
            </div>
          </div>
          <div class="login-box">
            <div class="input-wrapper">
              <span class="input-span">邮箱</span>
              <input
                type="text"
                class="login_input"
                placeholder="请输入邮箱"
                maxlength="20"
                v-model="email"
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
                v-model="password"
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
                v-model="confirmPasswrod"
              />
            </div>
          </div>
          <button class="login-button" type="submit">
            <span class="login-span">注册</span>
          </button>
        </div>
        <div class="reg-box">
          <span>第三方登录/注册</span>
          <div class="right-image">
            <button class="mat-focus-img">
              <img src="@/assets/image/WeChat.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="@/assets/image/QQ.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="@/assets/image/Github.png" alt="" />
            </button>
          </div>
        </div>
        <div class="login-reg-box">
          已有账号，
          <a href="javascript:;" @click="switchPage(1)">登录</a>
        </div>
      </div>
    </form>
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
        <button class="login-button">
          <span class="login-span">修改</span>
        </button>
        <div class="login-reg-box">
          已有账号，
          <a href="javascript:;" @click="switchPage(1)">立刻登录</a>
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
  justify-content: space-between;
  margin-top: 20px;
}

.reg-box a {
  color: #3494fc;
  text-decoration: none;
}

.login-reg-box {
  display: flex;
}

.reg-box ul {
  display: flex;
}

.reg-box li {
  margin-right: 10px;
}

.reg-box ul img {
  width: 20px;
  margin-left: 10px;
  cursor: pointer;
}

.right-image {
  display: flex;
}

.mat-focus-img {
  width: 40px;
  height: 40px;
  margin-left: 18px;
  border-radius: 50%;
  border-color: rgba(0, 0, 0, 0.12);
  line-height: 1;
  background: transparent;
}

.mat-focus-img img {
  width: 20px;
  cursor: pointer;
}

.code-button {
  height: 30px;
  padding: 5px;
}
</style>