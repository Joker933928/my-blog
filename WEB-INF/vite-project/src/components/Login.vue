<script>
import { getCurrentInstance, onMounted, ref } from "vue";
import { useRouter } from "vue-router";
 

export default {
  name: "Login",
  setup() {
    // 创建路由
    const router = useRouter();
    // 创建axios
    const {proxy} = getCurrentInstance();
    // 1 - 登录页 2 - 忘记密码 3 - 注册
    const state = ref(1);

    onMounted(() => {
      console.log(state.value);
    });

    let login_button = () => {
      console.log('a')
      router.push('/home')
    }

    const apiurl = 'http://localhost:8081/api/user/';

    const user = {
      username: 'admin',
      password: 123456
    }

    fetch(apiurl + 'login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(user),
    })
    .then(response => response.json())
    .then(data => {
      console.log(data)
    })

    return {
      state,
      login_button
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
        <button class="login-button" @click="login_button">
          <span class="login-span">登录</span>
        </button>
        <div class="reg-box">
          <span>第三方登录/注册</span>
          <div class="right-image">
            <button class="mat-focus-img">
              <img src="../assets/GitHub.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="../assets/QQ.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="../assets/WeChat.png" alt="" />
            </button>
          </div>
        </div>
        <div class="login-reg-box">
          没有账号，
          <a href="javascript:;" @click="state = 3">注册</a>
        </div>
      </div>
    </div>
    <!-- 注册页 -->
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
          <span class="login-span">注册</span>
        </button>
      </div>
      <div class="reg-box">
          <span>第三方登录/注册</span>
          <div class="right-image">
            <button class="mat-focus-img">
              <img src="../assets/GitHub.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="../assets/QQ.png" alt="" />
            </button>
            <button class="mat-focus-img">
              <img src="../assets/WeChat.png" alt="" />
            </button>
          </div>
          <!-- <ul>
            <li><img src="../assets/GitHub.png" alt="" /></li>
            <li><img src="../assets/QQ.png" alt="" /></li>
            <li><img src="../assets/WeChat.png" alt="" /></li>
          </ul> -->
        </div>
        <div class="login-reg-box">
          已有账号，
          <a href="javascript:;" @click="state = 1">登录</a>
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
        <div class="login-reg-box">
          已有账号，
          <a href="javascript:;" @click="state = 1">立刻登录</a>
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

.login-reg-box{
  display: flex;
}

ul,
li {
  list-style: none;
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

.right-image{
  display: flex;
}

.mat-focus-img{
  width: 40px;
  height: 40px;
  margin-left: 18px;
  border-radius: 50%;
  border-color:  rgba(0, 0, 0, .12);
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