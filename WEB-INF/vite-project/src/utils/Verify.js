const regs = {
    username: /^(?!.*\s)[\u4e00-\u9fa5a-zA-Z0-9]{1,20}$/,
    password: /^(?!.*\s)[\da-zA-Z~!@#$%^&*]{1,20}$/,
    email: /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/,
    nickname: /^(?!.*\s)[\u4e00-\u9fa5a-zA-Z0-9]{1,20}$/,
}

const verify = (rule,value,reg,callback) => {
    if(value) {
        if(reg.test(value)){
            callback()
        } else {
            callback(new Error(rule.message))
        }
    } else {
        callback()
    }
}

export default {
    username: (rule,value,callback) => {
        return verify(rule,value,regs.username,callback)
    },
    password: (rule,value,callback) => {
        return verify(rule,value,regs.password,callback)
    },
    email: (rule,value,callback) => {
        return verify(rule,value,regs.email,callback)
    },
    nickname: (rule,value,callback) => {
        return verify(rule,value,regs.nickname,callback)
    },
}
