<template>
    <el-row :gutter="20">
        <el-col :span="4">
            <el-image :src="header_image_whut" class="header-image-whut" ></el-image> 
        </el-col>
        <el-col :span="16" class="header-whut-Bioinformatics-Laboratory" style="padding-left: 50px">武汉理工大学生物信息实验室</el-col>
        <el-col :span="4" class="header-out "><el-link :underline="false" style="color : black">退出</el-link></el-col>
    </el-row>
</template>

<style lang="scss" scoped >

.el-row {
    margin-bottom: 20px;
    &:last-child {
        margin-bottom: 0;
    }
}
.el-col {
    height: 60px;
}
.header-image-whut{
    height: 60px;
    width: 252px; 
    margin-top: 0;
}
.header-whut-Bioinformatics-Laboratory{
    font-size: 30px;
    letter-spacing: 15px;
    font-weight: 550;
    height: 60px;
    padding: 8px 0 0 50px;
    font-family: "Microsoft Yahei";
}
.header-out{
    padding-left: 13% !important;
    padding-top: 2.4%;
}

</style>

<script>
export default {
    data() {
        return {
            header_image_whut : require('@/assets/images/whutlogo.png')
        }
    },

}
</script>