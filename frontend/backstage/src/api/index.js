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
//获取所有显示在浏览页面上
export const getNewsall = () => ajax("/news/findAll", {}) 
//获取细节
export const url_getNewsIndex = "/news/findById/"
export const getNewsIndex = (url_getNewsIndex, data) => ajax(url_getNewsIndex, data) 
//更新
export const url_updataNewsIndex = "/news/updateNews/"
export const updataNewsIndex = (url_updataNewsIndex, data, type) => ajax(url_updataNewsIndex, data, "post") 
//插入
export const url_insertNews = "/news/insertNews/"
export const insertNews = (url_insertNews, data, type) => ajax(url_insertNews, data, "post") 
//删除
export const url_deleteNews = "/news/deleteById/"
export const deleteNews = (url_deleteNews, data, type) => ajax(url_deleteNews, data, "get") 

//通知公告
//获取所有显示在浏览页面上
export const getNoticeall = () => ajax("/notice/findAll", {}) 
//获取细节
export const url_getNoticetIndex = "/notice/findById/"
export const getNoticetIndex = (url_getNoticetIndex, data) => ajax(url_getNoticetIndex, data) 
//更新
export const url_updataNoticeIndex = "/notice/updateNotice/"
export const updataNoticeIndex = (url_updataNoticeIndex, data, type) => ajax(url_updataNoticeIndex, data, "post") 
//插入
export const url_insertNotice = "/notice/insertNotice/"
export const insertNotice = (url_insertNotice, data, type) => ajax(url_insertNotice, data, "post") 
//删除
export const url_deleteNotice = "/notice/deleteById/"
export const deleteNotice = (url_deleteNotice, data, type) => ajax(url_deleteNotice, data, "get") 

//科研工作——论文
//获取所有显示在浏览页面上
export const getArticleall = () => ajax("/thesis/findAll", {}) 
//获取细节
export const url_getArticleIndex = "/thesis/findById/"
export const getArticleIndex = (url_getArticleIndex, data) => ajax(url_getArticleIndex, data) 
//更新
export const url_updataArticleIndex = "/thesis/updateThesis/"
export const updataArticleIndex = (url_updataArticleIndex, data, type) => ajax(url_updataArticleIndex, data, "post") 
//插入
export const url_insertArticle = "/thesis/insertThesis/"
export const insertArticle = (url_insertArticle, data, type) => ajax(url_insertArticle, data, "post") 
//删除
export const url_deleteArticle = "/thesis/deleteById/"
export const deleteArticle = (url_deleteArticle, data, type) => ajax(url_deleteArticle, data, "get") 


//科研工作——会议
//获取所有显示在浏览页面上
export const getAcademicall = () => ajax("/meeting/findAll", {}) 
//获取细节
export const url_getAcademicIndex = "/meeting/findById/"
export const getAcademicIndex = (url_getAcademicIndex, data) => ajax(url_getAcademicIndex, data) 
//更新
export const url_updataAcademicIndex = "/meeting/updateMeeting/"
export const updataAcademicIndex = (url_updataAcademicIndex, data, type) => ajax(url_updataAcademicIndex, data, "post") 
//插入
export const url_insertAcademic = "/meeting/insertMeeting/"
export const insertAcademic = (url_insertAcademic, data, type) => ajax(url_insertAcademic, data, "post") 
//删除
export const url_deleteAcademic = "/meeting/deleteById/"
export const deleteAcademic = (url_deleteAcademic, data, type) => ajax(url_deleteAcademic, data, "get") 

//科研工作——资源
//获取所有显示在浏览页面上
export const getSourceall = () => ajax("/resource/findAll", {}) 
//获取细节
export const url_getSourceIndex = "/resource/findById/"
export const getSourceIndex = (url_getSourceIndex, data) => ajax(url_getSourceIndex, data) 
//更新
export const url_updataSourceIndex = "/resource/updateResource/"
export const updataSourceIndex = (url_updataSourceIndex, data, type) => ajax(url_updataSourceIndex, data, "post") 
//插入
export const url_insertSource = "/resource/insertResource/"
export const insertSource = (url_insertSource, data, type) => ajax(url_insertSource, data, "post") 
//删除
export const url_deleteSource = "/resource/deleteById/"
export const deleteSource = (url_deleteSource, data, type) => ajax(url_deleteSource, data, "get") 