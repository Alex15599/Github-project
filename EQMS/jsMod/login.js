const usernameInput = document.getElementsByName("工号")[0];
const passwordInput = document.getElementsByName("密码")[0];
const captchaInput = document.getElementsByName("验证")[0];

document.forms[0].addEventListener("submit", function(event) {
  event.preventDefault();
  
  // TODO: 检查表单数据的完整性
  
  const xhr = new XMLHttpRequest();
  xhr.onload = function() {
    if (xhr.status === 200) {
      window.location.replace("/home.html");
    } else {
      // TODO: 处理登陆错误
    }
  };
  xhr.open("POST", "/login");
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.send(JSON.stringify({
    工号: usernameInput.value,
    密码: passwordInput.value,
    验证码: captchaInput.value
  }));
  
});