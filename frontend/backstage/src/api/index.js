import ajax from './ajax';


/**
 * ajax(url,data,type)
 * @param url  请求地址
 * @param data  请求数据
 * @param type  请求方式
 */
//Home
export const test = () => ajax("/", {}) //测试


//图片插入
export const url_uploadPic = process.env.VUE_APP_BASE_API + "/news/uploadPic"


//新闻发布
//获取所有新闻显示在浏览页面上
export const getNewsall = () => ajax("/news/findAll", {}) 
//获取新闻细节
export const url_getNewsIndex = "/news/findById/"
export const getNewsIndex = (url_getNewsIndex, data) => ajax(url_getNewsIndex, data) 
//更新通知
export const url_updataNewsIndex = "/news/updateNews/"
export const updataNewsIndex = (url_updataNewsIndex, data, type) => ajax(url_updataNewsIndex, data, "post") 
//插入通知
export const url_insertNews = "/news/insertNews/"
export const insertNews = (url_insertNews, data, type) => ajax(url_insertNews, data, "post") 
// //删除通知
// export const url_deleteNotice = "/notice/deleteById/"
// export const deleteNotice = (url_deleteNotice, data, type) => ajax(url_deleteNotice, data, "get") 



//通知公告
//获取所有通知显示在浏览页面上
export const getNoticeall = () => ajax("/notice/findAll", {}) 
//获取通知细节
export const url_getNoticetIndex = "/notice/findById/"
export const getNoticetIndex = (url_getNoticetIndex, data) => ajax(url_getNoticetIndex, data) 
//更新通知
export const url_updataNoticeIndex = "/notice/updateNotice/"
export const updataNoticeIndex = (url_updataNoticeIndex, data, type) => ajax(url_updataNoticeIndex, data, "post") 
//插入通知
export const url_insertNotice = "/notice/insertNotice/"
export const insertNotice = (url_insertNotice, data, type) => ajax(url_insertNotice, data, "post") 
//删除通知
export const url_deleteNotice = "/notice/deleteById/"
export const deleteNotice = (url_deleteNotice, data, type) => ajax(url_deleteNotice, data, "get") 


export const testhello = () => ajax("http://192.168.1.127:8083/haha/hello", {}) //通知
export const testhello1 = (url, data,type) => ajax(url, data,type) //通知