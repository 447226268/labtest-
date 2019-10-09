//简单的封装一下axios请求

import axios from 'axios'

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,//默认添加baseurl
})



//请求前需要处理的参数  -- 比如：token
service.interceptors.request.use(
  config => {
    return config;
  },
  error => {
    Promise.reject(error);
  }
);
//响应后需要处理的参数  -- 比如：判断token失效
service.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    return Promise.reject(error);
  }
);

//外部使用axios
export default function ajax(url, data={}, type='GET') {
  return service({
    url,
    method:type,
    data
  })
}

