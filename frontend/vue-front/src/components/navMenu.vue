<template>
	<div>
	<el-row class="tac">
		
	<el-col :span="18">
	
	<el-menu
	default-active="2"
	class="el-menu-vertical-demo"
	@open="handleOpen"
	@close="handleClose"
	background-color="#545c64"
	text-color="#fff"
	active-text-color="#ffd04b">
	<el-menu-item index="1"  @click="select('main')">
			<i class="el-icon-menu"></i>
			<span slot="title">主页</span>
		</el-menu-item>
	<el-submenu index="2">
	<template slot="title">
	<i class="el-icon-location"></i>
	<span>货单管理</span>
	</template>
	<el-menu-item-group>
	
	<el-menu-item index="2-1"  @click="select('neworder')">新建发货单</el-menu-item>
	<el-menu-item index="2-2" @click="select('orderlist')">浏览发货单</el-menu-item>
	<el-menu-item index="2-3"  @click="select('searchOrder')">查询发货单</el-menu-item>
	
	</el-menu-item-group>
	
	
	</el-submenu>
	
	<el-submenu index="3">
	<template slot="title">
	<i class="el-icon-location"></i>
	<span>仓库管理</span>
	</template>
	<el-menu-item-group>
	
	<el-menu-item index="3-1"  @click="select('storagelist')">浏览库存</el-menu-item>
	<el-menu-item index="3-2"  @click="select('searchStorage')">查询库存</el-menu-item>
	<el-menu-item index="3-3">预留选项</el-menu-item>
	</el-menu-item-group>
	
	
	</el-submenu>
	
	</el-menu>
	</el-col>
	</el-row>
	</div>
</template>

<script>
	export default {
	methods: {
		handleOpen(key, keyPath) {
		window.console.log(key, keyPath);
		},
		handleClose(key, keyPath) {
		window.console.log(key, keyPath);
		},
		select(s){
				this.$emit('func',s)
		}
		
		
		
		
		
    }
  }
</script>

<style>
</style>
