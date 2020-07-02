/*
 * @Author: 码上talk|RC
 * @Date: 2020-06-29 14:20:44
 * @LastEditTime: 2020-06-29 16:06:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/_git/index.js
 * @Just do what I think it is right
 */
var request = require('request')
var exec = require('child_process').exec

var _cmd = (cmd, callback) => {
    exec('git show -s', (error, stdout, stderr) => {
        if (!error) {
            callback(stdout)
        }
    })
}

var _post = (url, form, callback) => {
    request({
        url: url,
        method: "POST",
        headers: {
            "content-type": "application/x-www-form-urlencoded",
        },
        form
    }, (error, response, body) => {
        if (!error && response.statusCode == 200) {
            callback && callback(body)
        }
    })
}

var run = () => {
    var qq_push_url = 'http://127.0.0.1:8080/git/group/push'
    _cmd('git show -s', (stdout) => {
        _post(qq_push_url, {
            group: [],
            msg: `tacomall-springboot项目已更新：\n ${stdout} \n 链接：https://gitee.com/running-cat/tacomall-springboot \n --消息来之git自动化推送`
        })
    })
}

run()