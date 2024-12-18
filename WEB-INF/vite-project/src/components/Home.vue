<template>
    <div class="wrapper">
        <div class="top-box">
            <nav class="top-main">
                <div class="top-left">
                        <ul class="nav-list">
                            <li class="navbar-building">
                                <a href="">
                                    <img src="">
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;">首页</a>
                            </li>
                            <li>
                                <a href="javascript:;">文章</a>
                            </li>
                            <li>
                                <a href="javascript:;">碎碎念</a>
                            </li>
                            <li>
                                <a href="javascript:;">友联</a>
                            </li>
                            <li>
                                <a href="javascript:;">关于</a>
                            </li>
                            <li>
                                <a href="javascript:;">留言板</a>
                            </li>
                        </ul>
                </div>
                <div class="top-right">
                    <input type="text" placeholder="请输入内容">
                </div>
            </nav>
        </div>
        <h1>首页</h1>
    </div>
    
</template>

<script setup>
import {ref} from 'vue'




</script>


<style scoped>

.wrapper {
    background: pink;
    width:1000px;
    height: 800px;
    margin: 0px auto; 
}

.top-box {
    width: 100%;
    background: red;
    font-size: 15px;
    color: #666;
    align-items: center;
}

.top-main{
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
}

.top-left{

}

.top-right{
    background: purple;
}

.nav-list{
    display:flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: nowrap;
    padding: 10px;
}

/* 父元素 ul li 除了第一个li不用外边距 */
.top-left ul li:not(:first-child) {
    margin-left: 33px;
}

</style>
