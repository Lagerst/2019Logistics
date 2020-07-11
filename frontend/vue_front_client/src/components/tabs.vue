<template>
  <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
    <el-tab-pane label="通知消息" name="first">通知消息</el-tab-pane>
    <el-tab-pane label="数据分析" name="second">数据分析</el-tab-pane>
    <el-tab-pane label="功能管理" name="third">功能管理</el-tab-pane>
    
  </el-tabs>
</template>
<script>
  export default {
    data() {
      return {
        activeName: 'first'
      };
    },
    methods: {
      handleClick(tab, event) {
        window.console.log(tab, event);
      }
    }
  };
</script>